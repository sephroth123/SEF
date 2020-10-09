package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import entity.StudentRole;

public class StudentRoleDao {

	static final String url = "jdbc:mysql://localhost:3306/lotus?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	static final String driver = "com.mysql.cj.jdbc.Driver";
	static final String user = "choishuyi";
	static final String password = "18OPPAsalanghe";

	Connection conn;
	Statement stmt;
	
	public void save(StudentRole sr) {
	};
	
	
	public void input(String sid, String RFid) {
		int count = 0;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("select count(1) as count from role;");
			while(rs.next()) {
			    count = rs.getInt("count");
			
			}
			
			stmt.executeLargeUpdate("INSERT INTO framework values ('SR"+(count+1)+"', '" +sid+"','"+RFid+"');");
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
		
	}

}
