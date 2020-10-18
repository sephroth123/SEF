package Student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.configration.DBConfig;
import entity.Project;

public class ProjectDao {

//	ArrayList<String> pidList;
//	Connection conn;
//	Statement stmt;

	public ArrayList<String> getPidList() {

		try {
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select PID from project");
			ArrayList<String> pidList = new ArrayList<String>();
			while (rs.next()) {
				String pid = rs.getString("PID");
				pidList.add(pid);
			}
			rs.close();
			stmt.close();
			conn.close();

			return pidList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public List<Project> listAll() {

		try {
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from project");
			List<Project> result = new ArrayList<Project>();

			while (rs.next()) {

				String pid = rs.getString("PID");
				String cid = rs.getString("CID");
				String description = rs.getString("Description");
				Project project = new Project();
				project.setPid(pid);
				project.setC_id(cid);
				project.setDescription(description);
				result.add(project);
			}
			rs.close();
			stmt.close();
			conn.close();

			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public Project getById(String id) {

		try {
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			String sql = "select * from project Where pid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();

			Project project = null;
			while (rs.next()) {

				String pid = rs.getString("PID");
				String cid = rs.getString("CID");
				String description = rs.getString("Description");
				project = new Project();
				project.setPid(pid);
				project.setC_id(cid);
				project.setDescription(description);
			}
			rs.close();
			conn.close();

			return project;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

}
