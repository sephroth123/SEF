package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProjectDao {
	
	ArrayList<String> pidList;
	Connection conn;
	Statement stmt;
	
	static final String url = "jdbc:mysql://localhost:3306/lotus?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	static final String driver = "com.mysql.cj.jdbc.Driver";
	static final String user = "choishuyi";
	static final String password = "18OPPAsalanghe";
	
	public ArrayList<String> getPidList(){
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("Select PID from project");
			
			while(rs.next()) {
				String pid = rs.getNString("PID");
				pidList.add(pid);
			}
			rs.close();
			stmt.close();
			conn.close();
		} 
		catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pidList;
	}
}
