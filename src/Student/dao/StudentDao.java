package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import entity.Student;

public class StudentDao {

	HashMap<String, Student> stuMap = new HashMap<String, Student>();
	Student stu = new Student();
	
	static final String url = "jdbc:mysql://localhost:3306/lotus?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	static final String driver = "com.mysql.cj.jdbc.Driver";
	static final String user = "choishuyi";
	static final String password = "18OPPAsalanghe";
	
	public void save(Student s) {

	}
	
	public HashMap<String, Student> output(){
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * from student");
			while(rs.next()) {
				
				String sid = rs.getString("SID");
				String sname = rs.getString("sName");
				String password = rs.getNString("sPassword");
				String gender = rs.getNString("gender");
				String pType = rs.getNString("pType");
				int experence = rs.getInt("experence");
				double gpa = rs.getDouble("GPA");
				
				stu.setSid(sid);
				stu.setUserName(sname);
				stu.setPassword(password);
				stu.setGender(gender);
				stu.setPersonalityType(pType);
				stu.setExperience(experence);
				stu.setGpa(gpa);
				
				
				stuMap.put(sid, stu);
				
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
		
		return stuMap;
	}

}
