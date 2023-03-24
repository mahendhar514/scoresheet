package scoresheet;

import java.sql.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

public class PlayerRegLoginDAO {
	public int k = 0;
	public ArrayList<PlayerRegBean> al;
	public Connection con;

	// public boolean k1;
	public PlayerRegLoginDAO() {
		con = DBConnection.getCon();
		al = new ArrayList<>();
	}

	public int insert(PlayerRegBean pb) {
		try {
			con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("insert into players values(?,?,?,?,?,?)");
			ps.setString(1, pb.getName());
			ps.setString(2, pb.getIc());
			ps.setString(3, pb.getTeam());
			ps.setInt(4, pb.getAge());
			ps.setLong(5, pb.getPhno());
			ps.setString(6, pb.getMail());
			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}

	public ArrayList<PlayerRegBean> search(HttpServletRequest req) {
		try {
			PreparedStatement ps = con.prepareStatement("select * from players where name=? and PHnumber=?");
			ps.setString(1, req.getParameter("name"));
			ps.setLong(2, Long.parseLong(req.getParameter("phno")));
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				PlayerRegBean pb = new PlayerRegBean();
				pb.setName(rs.getString(1));
				pb.setIc(rs.getString(2));
				pb.setTeam(rs.getString(3));
				pb.setAge(rs.getInt(4));
				pb.setPhno(rs.getLong(5));
				pb.setMail(rs.getString(6));
				al.add(pb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

	public ArrayList<PlayerRegBean> modify(PlayerRegBean pb) {
		ArrayList<PlayerRegBean> al2 = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(
					"update players set name=?,ic=?,team=?,age=?,PHnumber=?,email=? where PHnumber=? and name=?");
			ps.setString(1, pb.getName());
			ps.setString(2, pb.getIc());
			ps.setString(3, pb.getTeam());
			ps.setInt(4, pb.getAge());
			ps.setLong(5, pb.getPhno());
			ps.setString(6, pb.getMail());
			ps.setLong(7, pb.getPhno());
			ps.setString(8, pb.getName());
			k = ps.executeUpdate();
			if (k > 0) {
				al2.add(pb);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}

		return al2;
	}
	
	public int delete(Long phno) {
		int k=0;
		try {
			PreparedStatement ps=con.prepareStatement("delete from players where PHnumber=?");
			ps.setLong(1, phno);
			k=ps.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}

}