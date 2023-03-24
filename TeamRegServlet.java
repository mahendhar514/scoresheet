package scoresheet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/TeamReg")
public class TeamRegServlet extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		TeamRegBean trb=new TeamRegBean();
		trb.setName(req.getParameter("tname"));
		trb.setDivision(req.getParameter("div"));
		trb.setClub(req.getParameter("club"));
		trb.setPrimaryName(req.getParameter("pname"));
		trb.setPrimaryNumber(Long.parseLong(req.getParameter("pphno")));
		trb.setPrimaryEmail(req.getParameter("peid"));
		trb.setSccName(req.getParameter("sname"));
		trb.setSccNumber(Long.parseLong(req.getParameter("sphno")));
		trb.setSccEmail(req.getParameter("seid"));
		int k=new TeamRegDAO().insert(trb);
		if(k>0) {
			pw.println("<h1 style='color:blue;'>Team Registered Seccessfully......</h1><br><br>");
			RequestDispatcher rDispatcher=req.getRequestDispatcher("team.html");
			rDispatcher.include(req, res);
		}else {
			pw.println("<h1 style='color:red;'> Team Already Registered.....</h1><br><br>");
			RequestDispatcher r1=req.getRequestDispatcher("team.html");
			r1.include(req, res);
		}
			
	}

}
