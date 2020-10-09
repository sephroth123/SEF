package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.Role;

public class RoleDao {
	
	Connection conn;
	Statement stmt;
	
	static final String url = "jdbc:mysql://localhost:3306/lotus?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	static final String driver = "com.mysql.cj.jdbc.Driver";
	static final String user = "choishuyi";
	static final String password = "18OPPAsalanghe";
	
	public void save(Role r) {

	}
	
	public String input(String rName) {
		
		int count = 0;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("select count(1) as count from role;");
			while(rs.next()) {
			    count = rs.getInt("count");
			
			}
			
			stmt.executeLargeUpdate("INSERT INTO role values ('R"+ (count+1)+"', '" +rName+"');");
			rs.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return "R"+(count+1);
	}

}
