package scoresheet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/playermodify")
@SuppressWarnings("serial")
public class modifyPlayer extends HttpServlet{

	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		PrintWriter pw =res.getWriter();
		res.setContentType("text/html");
		String button=req.getParameter("sub");
		if(button.equals("Modify")) {
			PlayerRegBean pb = new PlayerRegBean();
			pb.setName(req.getParameter("name"));
			pb.setIc(req.getParameter("ic"));
			pb.setTeam(req.getParameter("team"));
			pb.setAge(Integer.parseInt(req.getParameter("age")));
			pb.setMail(req.getParameter("email"));
			pb.setPhno(Long.parseLong(req.getParameter("phno")));
			ArrayList<PlayerRegBean> al =new PlayerRegLoginDAO().modify(pb);
			if(al.isEmpty()) {
				pw.println("<h2>Details not updated..</h2>");
				RequestDispatcher rd =req.getRequestDispatcher("PlayerDetails.jsp");
				rd.include(req, res);
			}
			else {
				req.setAttribute("play", al);
				RequestDispatcher rd=req.getRequestDispatcher("updatePlayer.jsp");
				rd.forward(req,res);
			}
		}else {
			Long phno=Long.parseLong(req.getParameter("phno"));
			int k=new PlayerRegLoginDAO().delete(phno);
			if(k>0) {
				pw.println("<h2 style='color:red;'>Details Deleted Successfully...</h2>");
				RequestDispatcher rd=req.getRequestDispatcher("searchforplayer.html");
				rd.forward(req, res);
			}
		}
	}
}
