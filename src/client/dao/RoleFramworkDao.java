package client.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.configration.DBConfig;
import entity.RoleFramework;

public class RoleFramworkDao {

	public void save(RoleFramework rf) {

		try {
			String sql = "INSERT INTO RoleFramework(RID,FID,RFID) VALUES('" + rf.getR_id() + "','" + rf.getF_id()
					+ "','" + rf.getId() + "')";
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			PreparedStatement ps = conn.prepareStatement(sql);

			System.out.println(sql);

			ps.executeUpdate(sql);
			conn.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		RoleFramework rf = new RoleFramework("R3", "F3", "RF7");

		RoleFramworkDao dao = new RoleFramworkDao();

		dao.save(rf);

	}

}
