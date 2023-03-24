package scoresheet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/player")
public class PlayerRegServlet extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		PlayerRegBean pb=new PlayerRegBean();
		pb.setName(req.getParameter("name"));
		pb.setIc(req.getParameter("ic"));
		pb.setTeam(req.getParameter("team"));
		pb.setAge(Integer.parseInt(req.getParameter("age")));
		pb.setPhno(Long.parseLong(req.getParameter("phone")));
		pb.setMail(req.getParameter("email"));
		int k=new PlayerRegLoginDAO().insert(pb);
		if(k>0) {
			pw.println("<h1 style='color:blue;'>Player registered Successfully....</h1><br><br>");
			RequestDispatcher rd=req.getRequestDispatcher("PlayerReg.html");
			rd.include(req, res);
		}else {
			pw.println("<h1 style='color:blue;'>Player already registered....</h1><br><br>");
			RequestDispatcher rd=req.getRequestDispatcher("PlayerReg.html");
			rd.include(req, res);
			
		}
		
	}
}