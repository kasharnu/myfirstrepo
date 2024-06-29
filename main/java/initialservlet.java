

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/initialservlet")
public class initialservlet extends HttpServlet {
	
	public void service(HttpServletRequest req,HttpServletResponse res) {
//		try {
//			
//			String sname=req.getParameter("sname");
//			int mark1=Integer.parseInt(req.getParameter("mark1"));
//			int mark2=Integer.parseInt(req.getParameter("mark2"));
//			
//			if(sname.length()==0) {
//				RequestDispatcher rd=req.getRequestDispatcher("invalidpage.java");
//				try {
//					rd.forward(req, res);
//				} catch (ServletException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				};
//			}
		
//			String str="insert into studentmarks values(?,?,?);";
//			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/student", "root", "Root88");
//			PreparedStatement ps=con.prepareStatement(str);
//			ps.setString(1, sname);
//			ps.setInt(2, mark1);
//			ps.setInt(3, mark2);
//			ps.execute();
//			String str1="select * from studentmarksz";
//			PreparedStatement ps1=con.prepareStatement(str1);
//			ResultSet rs=ps1.executeQuery();
//			while(rs.next()) {
//				String n=rs.getString("snmae");
//				int m1=rs.getInt("m1"); 
//				int m2=rs.getInt("m2");
//				try {
//				PrintWriter pw=res.getWriter();
//				pw.println("name:"+n+"mark1:"+m1+"mark2:"+m2);
//				}
//				catch(Exception e) {
//					e.printStackTrace();		
//				}
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//	
//	}
//	
	
		
		
}
}
