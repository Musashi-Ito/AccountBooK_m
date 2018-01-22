package model_pay;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class SetPay implements java.io.Serializable{

	public SetPay(){}

	public boolean execute(Payed p){
		Connection con = null;
		try {//登録
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample;create=true", "user", "pass");
			String sql = "INSERT INTO  pay_tbl (ID,itemname,day,money) VALUES (?, ?, ? ,?)";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, p.getId());
			stmt.setString(2, p.getItemname());
			stmt.setString(3, p.getDay());
			stmt.setInt(4, p.getMoney());
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
