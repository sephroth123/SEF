package Student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import common.configration.DBConfig;
import entity.Student;

public class StudentDao {

	HashMap<String, Student> stuMap = new HashMap<String, Student>();

	public int getAllStudentNumber() {

		try {
			String sql = "SELECT count(*) AS count from student";
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int result = 0;
			while (rs.next()) {

				result = rs.getInt("count");
			}

			conn.close();
			ps.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

}
