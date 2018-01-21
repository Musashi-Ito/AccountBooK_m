package model_fix;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SetFix implements java.io.Serializable{

	public SetFix(){}

	public boolean execute(Fixity f){
		Connection con = null;
		try {//登録
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample;create=true", "user", "pass");
			String sql = "INSERT INTO fixedbudget_tbl (ID,TYPE,MONEY,DAY) VALUES (?, ?, ? ,?)";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, f.getId());
			stmt.setString(2, f.getType());
			stmt.setInt(3, f.getMoney());
			stmt.setInt(4, f.getDay());
			stmt.executeUpdate();

			ResultSet rest = stmt.executeQuery();

			while (rest.next()) {
				//f.setId(rest.getInt("ID"));
				//f.setMoney(rest.getInt("Monay"));
				//f.setType(rest.getString("Type"));
				//f.setDay(rest.getInt("Day"));
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
