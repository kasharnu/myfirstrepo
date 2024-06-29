

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

import initialpro.LoginP;


@WebServlet("/myloginservlet")
public class myloginservlet extends HttpServlet {
	Connection cn;
	PreparedStatement ps;
	public void service(HttpServletRequest req, HttpServletResponse res) {
		String un=req.getParameter("username");
		String pass=req.getParameter("password");
		boolean check=LoginP.isvalid(un,pass);
		if(check) {
			String str="select mark1, mark2, stat from results where username=? and pass=?";
			int m1=0, m2=0;
			String sts="";
			try {
				 PrintWriter pw=res.getWriter();
				cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/student","root","Root88");
				 ps=cn.prepareStatement(str);
				ps.setString(1, un);
				ps.setString(2, pass);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {	  
	             m1 = rs.getInt("mark1"); 
	              m2 = rs.getInt("mark2"); 
		         sts = rs.getString("stat"); 
				}  
	               pw.print(m1+" "+m2+" "+sts);
			}
			catch(Exception e) {
				System.out.println("error");
			}
		}
		else {
			RequestDispatcher rd=req.getRequestDispatcher("loginpage.html");
			try {
				
				rd.forward(req, res);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}
public void destroy(HttpServletRequest req, HttpServletResponse res) {
	try {
		cn.close();
		ps.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
