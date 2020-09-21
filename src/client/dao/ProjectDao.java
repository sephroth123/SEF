package client.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.Project;

public class ProjectDao {

	public void save(Project p) {

		try {
			String sql = "INSERT INTO Project(pid,cid,description) VALUES('" + p.getPid() + "','" + p.getCid() + "','"
					+ p.getDescription() + "')";
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			PreparedStatement ps = conn.prepareStatement(sql);

//			ps.setString(1, p.getPid());
//			ps.setString(2, p.getCid());
//			ps.setString(3, p.getDescription());

			System.out.println(sql);

			ps.executeUpdate(sql);
			conn.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		Project p = new Project();

		p.setPid("P8");
		p.setCid("C3");
		p.setDescription("xxxx");

		ProjectDao dao = new ProjectDao();

		dao.save(p);

	}

}
