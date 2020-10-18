package Student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import common.configration.DBConfig;
import entity.StudentRole;

public class StudentRoleDao {

//	public void save(StudentRole sr) {
//	};

	public void save(StudentRole sr) {
		try {
			String sql = "INSERT INTO studentrole VALUES('" + sr.getId() + "','" + sr.getS_id() + "','" + sr.getRf_id()
					+ "')";
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			Statement stmt = conn.createStatement();

			stmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
