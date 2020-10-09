package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import entity.StudentPreference;

public class StudentPreferenceDao {
	
	static final String url = "jdbc:mysql://localhost:3306/lotus?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	static final String driver = "com.mysql.cj.jdbc.Driver";
	static final String user = "choishuyi";
	static final String password = "18OPPAsalanghe";
	
	HashMap<String, StudentPreference> preMap = new HashMap<String, StudentPreference>();
	StudentPreference sp = new StudentPreference();
	public void save(StudentPreference sp) {
		
	}
	
	public HashMap<String, StudentPreference> output(){
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * from studentpreference");
			while(rs.next()) {
				
				String sid = rs.getString("SID");
				String P1 = rs.getString("p1");
				String P2 = rs.getNString("p2");
				String P3 = rs.getNString("p3");
				String P4 = rs.getNString("p4");
				String disSid1 = rs.getNString("dislike1");
				String disSid2 = rs.getString("dislike2");
				String disSid3 = rs.getNString("dislike3");
				
				sp.setSid(sid);
				sp.setP1(P1);
				sp.setP2(P2);
				sp.setP3(P3);
				sp.setP4(P4);
				sp.setDisSid1(disSid1);
				sp.setDisSid2(disSid2);
				sp.setDisSid3(disSid3);
				
				preMap.put(sid, sp);
				
				rs.close();
				stmt.close();
				conn.close();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return preMap;
	}
	
	public void input(StudentPreference spre) {
		
		Connection conn = null;
		Statement stmt = null;
		
		//得到一个studentpreference
		String sid = spre.getSid();
		String p1 = spre.getP1();
		String p2 = spre.getP2();
		String p3 = spre.getP3();
		String p4 = spre.getP4();
		String dis1 = spre.getDisSid1();
		String dis2 = spre.getDisSid2();
		String dis3 = spre.getDisSid3();
		
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			
			stmt.executeLargeUpdate("update studentpreference set "
					+ "dislike1 = '" + dis1 + "'"
					+", dislike2 = '" + dis2 + "'"
					+", dislike3 = '" + dis3 + "'"
					+", p1 = '" + p1 + "'"
					+", p2 = '" + p2 + "'"
					+", p3 = '" + p3 + "'"
					+", p4 = '" + p4 + "'"
					+" where SID = '"+ sid +"';");
			
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
