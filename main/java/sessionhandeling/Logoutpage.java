package sessionhandeling;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logoutpage
 */
@WebServlet("/Logoutpage")
public class Logoutpage extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		RequestDispatcher rd=req.getRequestDispatcher("general.html");
		rd.include(req, res);
		HttpSession hp=req.getSession();
		hp.invalidate();
		pw.print("logged out successfully");
		pw.close();
	}
	
}
