package model_fix;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.UserMoney;

public class GetFix implements java.io.Serializable{

	public GetFix(){}

	public UserMoney execute(int id){
		Connection con = null;
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample;create=true", "user", "pass");
			String sql = "SELECT * FROM fixedbudget_tbl WHERE ID = ?";

			PreparedStatement stmt = con.prepareStatement(sql);

			//System.out.println("");

			stmt.setInt(1,id);
			ResultSet rest = stmt.executeQuery();

			while (rest.next()) {
				UserMoney um = new UserMoney(id,rest.getInt("START"), rest.getInt("GOAL"));

				return um;
			}

			return null;
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
		return null;

	}


}