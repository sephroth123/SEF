package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.RoleFramework;

public class RoleFramworkDao {
	
	Connection conn;
	Statement stmt;
	
	static final String url = "jdbc:mysql://localhost:3306/lotus?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	static final String driver = "com.mysql.cj.jdbc.Driver";
	static final String user = "choishuyi";
	static final String password = "18OPPAsalanghe";
	
	public void save(RoleFramework rf) {

	}
	
	public String input(String rid, String fid) {
		int count = 0;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("select count(1) as count from role;");
			while(rs.next()) {
			    count = rs.getInt("count");
			
			}
			
			stmt.executeLargeUpdate("INSERT INTO framework values ('"+ rid+"', '" +fid+"','RF"+(count+1)+"');");
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
		return "RF"+(count+1);
	}
	

}