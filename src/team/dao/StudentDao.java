package team.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.configration.DBConfig;
import entity.Student;

public class StudentDao {

	public Student getByiD(String sid) {
		try {
			String sql = " select * from Student where sid =?";
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, sid);
			ResultSet rs = ps.executeQuery();
			Student student = null;
			while (rs.next()) {
				student = new Student();
				student.setSid(rs.getString("SID"));
				student.setUserName(rs.getString("sName"));
				student.setPassword(rs.getString("sPassword"));
				student.setGender(rs.getString("gender"));
				student.setPersonalityType(rs.getString("pType"));
				student.setExperience(rs.getInt("experence"));
				student.setGpa(rs.getDouble("GPA"));
			}

			conn.close();
			ps.close();
			return student;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Student> listAll() {

		try {
			String sql = " select * from Student";
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Student student = null;
			List<Student> result = new ArrayList<Student>();
			while (rs.next()) {
				student = new Student();
				student.setSid(rs.getString("SID"));
				student.setUserName(rs.getString("sName"));
				student.setPassword(rs.getString("sPassword"));
				student.setGender(rs.getString("gender"));
				student.setPersonalityType(rs.getString("pType"));
				student.setExperience(rs.getInt("experence"));
				student.setGpa(rs.getDouble("GPA"));

				result.add(student);
			}

			conn.close();
			ps.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
