package team.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.configration.DBConfig;
import entity.Weight;

public class WeightDao {

	public Weight listByConstraintAll(String constraint) {

		try {
			String sql = "select * from Weight w where w.`constraint` =?";
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, constraint);
			ResultSet rs = ps.executeQuery();
			Weight weight = null;
			while (rs.next()) {
				weight = new Weight();
				weight.setwId(rs.getString("wId"));
				weight.setConstraint(rs.getString("constraint"));
				weight.setWeight(rs.getInt("weight"));
			}

			conn.close();
			ps.close();
			return weight;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<Weight> listAll() {

		try {
			String sql = " select * from Weight";
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Weight> result = new ArrayList<Weight>();
			Weight weight = null;
			while (rs.next()) {
				weight = new Weight();
				weight.setwId(rs.getString("wId"));
				weight.setConstraint(rs.getString("constraint"));
				weight.setWeight(rs.getInt("weight"));
				result.add(weight);
			}

			conn.close();
			ps.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public void update(String wId, int weight) {

		try {
//			String sql = "UPDATE Weight SET weight = " + String.valueOf(weight) + "WHERE wId ='" + wId + "' ";
			String sql = "UPDATE Weight SET weight = ? " + " WHERE wId = ?";
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, weight);
			ps.setString(2, wId);
			ps.executeUpdate();
			conn.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		WeightDao dao = new WeightDao();

		Weight w = dao.listByConstraintAll("personalitytype");
		System.out.println(w);
//		for (Weight weight : list) {
//			System.out.println(weight);
//		}

//		dao.update("w1", 5);
//
//		list = dao.listAll();
//		for (Weight weight : list) {
//			System.out.println(weight);
//		}

	}

}
