package initialpro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class credvalid {

	
	public static boolean isvaliddata(String un,String pas) {
		 boolean check=false;
	try {
		String str="select username ,pass from results where username=? and pass=?";
		Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Root88");
		PreparedStatement ps=cn.prepareStatement(str);
		ps.setString(1, un);
		ps.setString(2, pas);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			check=true;
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
		return check;
		
	}



}
