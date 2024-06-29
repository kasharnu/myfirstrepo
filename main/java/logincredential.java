

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import initialpro.credvalid;

/**
 * Servlet implementation class logincredential
 */
@WebServlet("/logincredential")
public class logincredential extends HttpServlet {
	Connection cn;
	PreparedStatement ps;
	ResultSet rs;
	public void doPost(HttpServletRequest req,HttpServletResponse res) {
		String u_name=req.getParameter("uname");
		String pass=req.getParameter("pass");	
		try {
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		boolean check=credvalid.isvaliddata(u_name,pass);
		
				if(check)
		{
			String sr="select name,mark1,mark2,stat from results where username=? and pass=?";
			try {
				 cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Root88");
				 ps=cn.prepareStatement(sr);
				ps.setString(1,u_name );
				ps.setString(2, pass);
				
				HttpSession hst=req.getSession();
				hst.setAttribute("username",u_name);
				
				RequestDispatcher rd=req.getRequestDispatcher("gettingdata");
				try {
					rd.forward(req, res);
				} catch (ServletException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			/*	String data=(String)hst.getAttribute("username");
				
				System.out.println(data);*/
//				
//				Cookie ckc=new Cookie("UNp",u_name );
//				Cookie ck1=new Cookie("pass",pass );
//				ckc.setMaxAge(60*60);
//				ck1.setMaxAge(60*60);
				
//				res.addCookie(ckc);
//				res.addCookie(ck1);
				
				
				 rs=ps.executeQuery();
				while(rs.next()) {
					String n=rs.getString("name");
					int m1=rs.getInt("mark1");
					int m2=rs.getInt("mark2");
					String sts=rs.getString("stat");
					
					PrintWriter pw;
					try {
						pw = res.getWriter();
						pw.println(n+" "+m1+" "+m2+" "+sts );
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			
			
			try {
				RequestDispatcher rd=req.getRequestDispatcher("logincred.html");
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
