package model_want;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetWantList implements java.io.Serializable{

	public GetWantList(){}

	public Wantlist execute(int id){
		Connection con = null;
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample;create=true", "user", "pass");
			String sql = "SELECT * FROM wantlist_tbl WHERE ID = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

			//System.out.println("");

			stmt.setInt(1,id);
			ResultSet rest = stmt.executeQuery();

			while (rest.next()) {
				Wantlist wl = new Wantlist(id, rest.getString("CATEGORY"), rest.getString("TRADENAME"),
											rest.getInt("PRIORITY"),rest.getInt("AMOUNT"));
				//UserMoney um = new UserMoney(id,rest.getInt("START"), rest.getInt("GOAL"));
				return wl;
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
		return null;
	}
}
