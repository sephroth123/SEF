package client.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.ProjectRole;

public class ProjectRoleDao {

	public void save(ProjectRole pr) {

		try {
			String sql = "INSERT INTO ProjectRole(PRID,PID,RFID) VALUES('" + pr.getPRID() + "','" + pr.getPID() + "','"
					+ pr.getRFID() + "')";
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			PreparedStatement ps = conn.prepareStatement(sql);

			System.out.println(sql);

			ps.executeUpdate(sql);
			conn.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	};

	public static void main(String[] args) {

		ProjectRole pr = new ProjectRole("PR11", "P5", "RF3");

		ProjectRoleDao dao = new ProjectRoleDao();

		dao.save(pr);

	}

}
