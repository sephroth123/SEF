package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.configration.DBConfig;
import entity.IDcreator;

public class IDcreatorDao {

	public static void update(IDcreator iDcreator) {
		try {
			String sql = "UPDATE IDcreator SET value = ?" + " WHERE id = ?";
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, iDcreator.getValue());
			ps.setInt(2, iDcreator.getId());
			ps.executeUpdate();
			conn.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void add(IDcreator iDcreator) {


		try {
			String sql = "INSERT INTO IDcreator(type,value) VALUES('" + iDcreator.getType() + "','"
					+ String.valueOf(iDcreator.getValue()) + "')";
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate(sql);
			conn.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static IDcreator getByType(String type) {
		try {
			String sql = " select * from IDcreator where type = ?";
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, type);
			ResultSet rs = ps.executeQuery();
			IDcreator result = null;
			while (rs.next()) {
				result = new IDcreator();
				result.setId(rs.getInt("id"));
				result.setType("type");
				result.setValue(rs.getInt("value"));
			}

			conn.close();
			ps.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
