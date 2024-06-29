package initialpro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginP {

	public static boolean  isvalid(String username, String password) {
		boolean check =false;
		String str="select * from results where username=? and pass=?";
		Connection cn;
		try {
			cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/student","root","Root88");
			PreparedStatement ps=cn.prepareStatement(str);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				check=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return check;
		
	}
}
