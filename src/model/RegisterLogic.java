package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterLogic implements java.io.Serializable{

	//例外処理:空文字(not null)

	public RegisterLogic(){}

	public void execute(User u){
		if(u.getAddress() != null || u.getPwd() != null){
			Connection con = null;
			try {
				Class.forName("org.apache.derby.jdbc.ClientDriver");
				con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample;create=true", "user", "pass");

				//String sql = "INSERT INTO USER_TBL VALUES (?,?,?)";

				String sql = "insert into user_tbl (name,address,password) values ('"+u.getName()+"','"+u.getAddress()+"','"+u.getPwd()+"')";
				System.out.println(sql);
				//String sql = "INSERT INTO USER_TBL VALUES (?,?)";
				PreparedStatement stmt = con.prepareStatement(sql);
				//ResultSet rs = stmt.getGeneratedKeys();
				//stmt.setInt(1, rs.getInt());

				//stmt.setString(2, u.getAddress());
				//stmt.setString(3, u.getPwd());

				//System.out.print(u.getAddress());
				//System.out.print(u.getPwd());
				int cnt = stmt.executeUpdate();
				//System.out.print(cnt);
			} catch(Exception e) {
				e.printStackTrace();
				return;
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch(SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
