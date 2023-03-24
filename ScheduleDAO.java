package scoresheet;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.*;
import javax.servlet.http.*;

public class ScheduleDAO {

	private int k;
	
	public int insertSch(ScheduleBean sb) {
		Connection con = DBConnection.getCon();
		try {
			PreparedStatement ps = con.prepareStatement("insert into schedule values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1, sb.getTeam1());
			ps.setString(2, sb.getTeam2());
			ps.setString(3, sb.getDay());
			ps.setDate(4, Date.valueOf(sb.getDate()));
			ps.setInt(5,sb.getCode());
			ps.setString(6,sb.getTime());
			ps.setString(7,sb.getSeason());
			ps.setString(8,sb.getDivison());
			ps.setInt(9,sb.getRound());
			System.out.println(sb.toString());
			k=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return k;
	}
	private ArrayList<ScheduleBean> al=new ArrayList<>();
	private ScheduleBean sb;
	public ArrayList<ScheduleBean> view(HttpServletRequest req) {
		Connection con=DBConnection.getCon();
		try {
			PreparedStatement ps=con.prepareStatement("select * from schedule where dates=?");
			ps.setDate(1,Date.valueOf(req.getParameter("dates").split(" ")[0]));
			System.out.println("outside rs");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				sb=new ScheduleBean();
				System.out.println("inside rs");
				sb.setTeam1(rs.getString(1));
				sb.setTeam2(rs.getString(2));
				sb.setDay(rs.getString(3));
				sb.setDate(rs.getString(4).split(" ")[0]);
				sb.setCode(rs.getInt(5));
				sb.setTime(rs.getString(6));
				sb.setSeason(rs.getString(7));
				sb.setDivison(rs.getString(8));
				sb.setRound(rs.getInt(9));
				al.add(sb);
			}
		} catch (Exception e) { e.printStackTrace();}
		return al;
	}

}