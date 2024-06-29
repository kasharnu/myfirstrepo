package controllerpro;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelpro.palindrome;

/**
 * Servlet implementation class servcontrol
 */
@WebServlet("/servcontrol")
public class servcontrol extends HttpServlet {
public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	int num=Integer.parseInt(req.getParameter("f1"));
	boolean check=palindrome.checkpali(num);
	RequestDispatcher rd=req.getRequestDispatcher("pali.jsp");
	rd.include(req, res);
//	int a=1;s
//	int b=2;
//	if(check) {
//		HttpSession htp=req.getSession();
//		htp.setAttribute("b1",a);
//	}
//	else {
//		HttpSession htp=req.getSession();
//		htp.setAttribute("b1",b);
//	}
	RequestDispatcher rd1=req.getRequestDispatcher("validate.jsp");
	rd1.forward(req, res);

}
}