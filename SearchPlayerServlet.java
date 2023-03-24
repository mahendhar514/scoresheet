package scoresheet;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/searchplayer")
public class SearchPlayerServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException, ServletException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		ArrayList<PlayerRegBean> al=new PlayerRegLoginDAO().search(req);
		if(al.isEmpty()) {
			pw.println("<h2>Player Details not Available.....Please Register</h2>");
			RequestDispatcher rd=req.getRequestDispatcher("searchforplayer.html");
			rd.include(req, res);
		}else {
			req.setAttribute("player", al);
			RequestDispatcher rd=req.getRequestDispatcher("PlayerDetails.jsp");
			rd.forward(req, res);
		}
	}
}