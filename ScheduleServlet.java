package scoresheet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/schedule")
public class ScheduleServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		ScheduleBean sb=new ScheduleBean();
		sb.setTeam1(req.getParameter("t1"));
		sb.setTeam2(req.getParameter("t2"));
		sb.setDay(req.getParameter("day"));
		sb.setDate(req.getParameter("date"));
		sb.setCode(Integer.parseInt(req.getParameter("code")));
		sb.setTime(req.getParameter("time"));
		sb.setSeason(req.getParameter("session"));
		sb.setDivison(req.getParameter("division"));
		sb.setRound(Integer.parseInt(req.getParameter("round")));
		System.out.println(req.getParameter("t1"));
		int k=new ScheduleDAO().insertSch(sb);
		if(k>0) {
			pw.println("<h1>Schedule Inserted Successfully....</h1><br><br>");
			RequestDispatcher rd=req.getRequestDispatcher("Schedule.html");
			rd.include(req, res);
		}
	}
}