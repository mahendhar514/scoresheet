package scoresheet;
import java.sql.*;
import java.util.ArrayList;

public class TeamRegDAO {
	int k=0;
	public ArrayList<TeamRegBean> al;
	public Connection con;
	public TeamRegDAO() {
		// TODO Auto-generated constructor stub
		con=DBConnection.getCon();
		al=new ArrayList<>();
	}
		
	
	public int insert(TeamRegBean trb) {
		try {
			con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("insert into team values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1,trb.getName());
			ps.setString(2, trb.getDivision());
			ps.setString(3, trb.getClub());
			ps.setString(4, trb.getPrimaryName());
			ps.setLong(5, trb.getPrimaryNumber());
			ps.setString(6, trb.getPrimaryEmail());
			ps.setString(7,trb.getSccName());
			ps.setLong(8, trb.getSccNumber());
			ps.setNString(9, trb.getSccEmail());
			
			k=ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
	public ArrayList<TeamRegBean> search(String name){
		try {
			PreparedStatement ps=con.prepareStatement
					("select * from team where name=?");
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				TeamRegBean pb=new TeamRegBean();
				pb.setName(rs.getString(1));
				pb.setDivision(rs.getString(2));
				pb.setClub(rs.getString(3));
				pb.setPrimaryName(rs.getString(4));
				pb.setPrimaryNumber(rs.getLong(5));
				pb.setPrimaryEmail(rs.getString(6));
				pb.setSccName(rs.getString(7));
				pb.setSccNumber(rs.getLong(8));
				pb.setSccEmail(rs.getString(9));
				al.add(pb);
			}
		}catch(Exception e) {e.printStackTrace();}
		return al;
	}
	public ArrayList<TeamRegBean> modify(TeamRegBean tr){
		 ArrayList<TeamRegBean> al3 =new ArrayList<TeamRegBean>();
		try {
			PreparedStatement ps=con.prepareStatement("update team set Division=?,Club=?,"
					+ "primary_name=?,primary_number=?,"
					+ "primary_email=?,sec_name=?,sec_num=?,sec_email=? where name=?");
			ps.setString(1, tr.getDivision());
			ps.setString(2, tr.getClub());
			ps.setString(3, tr.getPrimaryName());
			ps.setLong(4, tr.getPrimaryNumber());
			ps.setString(5, tr.getPrimaryEmail());
			ps.setString(6, tr.getSccName());
			ps.setLong(7, tr.getSccNumber());
			ps.setString(8, tr.getSccEmail());
			ps.setString(9,tr.getName());
			
			k=ps.executeUpdate();
			if(k>0) {
				al3.add(tr);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return al3;
	}
	
	public int delete(String teamName) {
		int k=0;
		try {
			PreparedStatement ps=con.prepareStatement("delete from team where name=?");
			ps.setNString(1, teamName);
			k=ps.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}
	

}
