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
@WebServlet("/searchteam")
public class SearchTeamServlet extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String name=req.getParameter("name");
		ArrayList<TeamRegBean> al=new TeamRegDAO().search(name);
		if(al.isEmpty()) {
			pw.println("<h2 style='color:red;'>Team Details not Available.....Please Register</h2>");
			RequestDispatcher rd=req.getRequestDispatcher("searchforteam.html");
			rd.include(req, res);
		}else {
			req.setAttribute("team", al);
			RequestDispatcher rd=req.getRequestDispatcher("teamDetails.jsp");
			rd.forward(req, res);
		}
	}

}
