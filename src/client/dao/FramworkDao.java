package client.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.Framework;

public class FramworkDao {

	public void save(Framework f) {

		try {
			String sql = "INSERT INTO framework(fid,fName) VALUES('" + f.getFid() + "','" + f.getfName() + "')";
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

		Framework f = new Framework();
		f.setFid("F6");
		f.setfName("xxxxx");
		FramworkDao dao = new FramworkDao();
		dao.save(f);

	}

}
