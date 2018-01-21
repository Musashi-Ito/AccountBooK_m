package model;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SetStart  implements java.io.Serializable{

public SetStart(){}

	/*
	public boolean execute(Fixity f){
		Connection con = null;
		try {//登録
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample;create=true", "user", "pass");
			String sql = "INSERT INTO start_tbl (ID,START,GOAL) VALUES (?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, f.getId());
			stmt.setInt(2, f.getBalance());
			stmt.setInt(3, f.getGoal());

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
	*/

	public boolean execute(UserMoney um){
		Connection con = null;
		try {//登録
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample;create=true", "user", "pass");
			String sql = "INSERT INTO start_tbl (ID,START,GOAL) VALUES (?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, um.getId());
			stmt.setInt(2, um.getBalance());
			stmt.setInt(3, um.getGoal());

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
