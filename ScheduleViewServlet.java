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
import javax.servlet.http.HttpSession;

@WebServlet("/viewsch")
@SuppressWarnings("serial")
public class ScheduleViewServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		HttpSession hs=req.getSession();
		System.out.println(req.getParameter("dates"));
		System.out.println("outside ser");
		ArrayList<ScheduleBean> al=new ScheduleDAO().view(req);
		System.out.println(al.size());
		if(al.size()==0) {
			System.out.println(req.getParameter("dates"));
			pw.println("There are no matches in this date<br>");
			RequestDispatcher rd=req.getRequestDispatcher("searchshedule.html");
			rd.include(req, res);
		}else {
			hs.setAttribute("schedule", al);
			for(ScheduleBean sb:al)
				System.out.println(sb);
			RequestDispatcher rd=req.getRequestDispatcher("ScheduleView.jsp");
			rd.forward(req, res);
		}
	}

}