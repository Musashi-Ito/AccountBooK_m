package model_want;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShowWantList implements java.io.Serializable {

	public ShowWantList(){}

	public ArrayList<String> execute(int id){
		Connection con = null;
		try {
			ArrayList<String> dat = new ArrayList<String>();
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample;create=true", "user", "pass");

			String sql = "SELECT * FROM wantlist_tbl WHERE ID = ?";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1,id);

			ResultSet rest = stmt.executeQuery();

			while (rest.next()) {
				dat.add(String.valueOf(rest.getInt("ID")));
				dat.add(rest.getString("CATEGORY"));
				dat.add(rest.getString("TRADENAME"));
				dat.add(String.valueOf(rest.getInt("PRIORITY")));
				dat.add(String.valueOf(rest.getInt("AMOUNT")));
			}

			return dat;
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
