package model_want;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SetWantList implements java.io.Serializable{

	public SetWantList() {}

	public boolean execute(Wantlist wl){
		Connection con = null;
		try {//登録
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample;create=true", "user", "pass");
			String sql = "INSERT INTO wantlist_tbl (ID,CATEGORY,TRADENAME,AMOUNT,PRIORITY) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, wl.getId());
			stmt.setString(2,wl.getCategory());
			stmt.setString(3, wl.getTradename());
			stmt.setInt(4, wl.getAmount());
			stmt.setInt(5, wl.getPriority());

			stmt.executeUpdate();

			ResultSet rest = stmt.executeQuery();

			while (rest.next()) {
				//f.setId(rest.getInt("ID"));
				//f.setBalance(rest.getInt("Start"));
				//f.setGoal(rest.getInt("Goal"));
				return true;
			}
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

}
