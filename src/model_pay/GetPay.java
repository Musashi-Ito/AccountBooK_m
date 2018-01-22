package model_pay;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model_fix.Fixity;

public class GetPay implements java.io.Serializable{

	public GetPay(){}

	public Payed execute(int id){
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
				Payed pay = new Payed(id, rest.getInt("START"), rest.getInt("GOAL"));

				return pay;
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
