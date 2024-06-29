package sessionhandeling;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import initialpro.credvalid;

/**
 * Servlet implementation class Loginservletpage
 */
@WebServlet("/Loginservletpage")
public class Loginservletpage extends HttpServlet {
	Connection cn;
	PreparedStatement ps;
	ResultSet rs;
	

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		String u_name = req.getParameter("uname");
		String pass = req.getParameter("pass");

		//boolean check = credvalid.isvaliddata(u_name, pass);
		RequestDispatcher rd = req.getRequestDispatcher("general.html");
		rd.include(req, res);
		if (u_name.equals("pradeepachar")) {
			String sr = "select name,mark1,mark2,stat from results where username=? and pass=?";
			HttpSession hst = req.getSession();
			hst.setAttribute("status", u_name);
			try {
				cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "Root88");
				ps = cn.prepareStatement(sr);
				ps.setString(1, u_name);
				ps.setString(2, pass);
				 rs=ps.executeQuery();
					while(rs.next()) {
						String n=rs.getString("name");
						int m1=rs.getInt("mark1");
						int m2=rs.getInt("mark2");
						String sts=rs.getString("stat");	
				
				
				
					}
					pw.print("hello"+u_name);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			pw.print("wrong credntials");
			RequestDispatcher rd1 = req.getRequestDispatcher("firstindex.html");
			rd1.include(req, res);
		}
	}
	public void destroy(HttpServletRequest req,HttpServletResponse res) {
		try {
			cn.close();
			ps.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}