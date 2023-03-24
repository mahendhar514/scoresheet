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
@SuppressWarnings("serial")
@WebServlet("/up")

public class TeamRegModi extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		PrintWriter p1=res.getWriter();
		res.setContentType("text/html");
		String button=req.getParameter("sub");
		if(button.equals("Modify")) {
			TeamRegBean trb=new TeamRegBean();
			trb.setName(req.getParameter("name"));
			trb.setDivision(req.getParameter("div"));
			trb.setClub(req.getParameter("club"));
			trb.setPrimaryName(req.getParameter("pname"));
			trb.setPrimaryNumber(Long.parseLong(req.getParameter("pnum")));
			trb.setPrimaryEmail(req.getParameter("pmail"));
			trb.setSccName(req.getParameter("sname"));
			trb.setSccNumber(Long.parseLong(req.getParameter("snum")));
			trb.setSccEmail(req.getParameter("smail"));
			ArrayList<TeamRegBean> al=new TeamRegDAO().modify(trb);
			if(al.isEmpty()) {
			p1.println("<h2 style='color:red;'>Team Name could not changable....... </h2><br><br>");
			RequestDispatcher rd=req.getRequestDispatcher("searchforteam.html");
			rd.include(req, res);
			}else {
			p1.println("<h2 style='color:blue;'>Modification succesfull.......</h2><br><br>");
			req.setAttribute("reg", al);
			RequestDispatcher rd=req.getRequestDispatcher("updateTeam.jsp");
			rd.forward(req, res);
			}
		}else {
			String teamName=req.getParameter("name");
			int k=new TeamRegDAO().delete(teamName);
			if(k>0) {
				p1.println("<h2 style='color:red;'>Details Deleted Successfully...</h2>");
				RequestDispatcher rd=req.getRequestDispatcher("searchforteam.html");
				rd.forward(req, res);
			}
		}
		
		
	}

}
