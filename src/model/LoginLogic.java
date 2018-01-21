package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginLogic implements java.io.Serializable{

	public LoginLogic (){}

	///*
	public boolean execute(User u){
		Connection con = null;
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample;create=true", "user", "pass");
			String sql = "SELECT * FROM USER_TBL WHERE ADDRESS = ? AND PASSWORD = ?";
			//String sql = "SELECT ID FROM USER_TBL WHERE ADDRESS = ? AND PASSWORD = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

			//System.out.println("");
			//System.out.println(u.getAddress());
			//System.out.println(u.getPwd());
			stmt.setString(1,u.getAddress());
			stmt.setString(2,u.getPwd());

			ResultSet rest = stmt.executeQuery();

			while (rest.next()) {
				//System.out.println(rest.getString("ID"));

				//u.setId(rest.getString("ID"));
				u.setId(rest.getInt("ID"));
				u.setName(rest.getString("NAME"));

				return true;
			}
			//*/
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	//*/
}
