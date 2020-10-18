package team.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.configration.DBConfig;
import entity.Team;

public class TeamDao {

	public void save(Team t) {

		try {
			String sql = "INSERT INTO Team(TID,SID1,SID2,SID3,SID4,PID,satisfaction) VALUES('" + t.getTid() + "','"
					+ t.getS_id1() + "','" + t.getS_id2() + "','" + t.getS_id3() + "','" + t.getS_id4() + "','"
					+ t.getP_id() + "','" + t.getSatisfaction() + "')";
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate(sql);
			conn.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateSatisfaction(String teamId, String satisfaction) {

		try {
			String sql = "UPDATE Team SET satisfaction = ? " + " WHERE tid = ?";
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, satisfaction);
			ps.setString(2, teamId);
			ps.executeUpdate();
			conn.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		Team t = new Team();
		t.setP_id("P1");
		t.setS_id1("S1");
		t.setS_id2("S2");
		t.setS_id3("S3");
		t.setS_id4("S4");
		t.setTid("T5");

		TeamDao dao = new TeamDao();

		dao.save(t);

	}

}
