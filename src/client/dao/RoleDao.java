package client.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import configration.DBConfig;
import entity.Role;

public class RoleDao {

	public void save(Role r) {

		try {
			String sql = "INSERT INTO Role(RID,rName) VALUES('" + r.getRid() + "','" + r.getrName() + "')";
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

		Role r = new Role("R10", "data analyst");

		RoleDao dao = new RoleDao();

		dao.save(r);

	}

}
