package Student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import common.configration.DBConfig;
import entity.StudentPreference;

public class StudentPreferenceDao {

	HashMap<String, StudentPreference> preMap = new HashMap<String, StudentPreference>();

	public List<StudentPreference> getStudentPreferenceList() {

		try {
			String sql = "SELECT * from studentpreference";
			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<StudentPreference> result = new ArrayList<StudentPreference>();
			while (rs.next()) {

				StudentPreference sp = new StudentPreference();

				String sid = rs.getString("SID");
				String P1 = rs.getString("p1");
				String P2 = rs.getNString("p2");
				String P3 = rs.getNString("p3");
				String P4 = rs.getNString("p4");
				String disSid1 = rs.getNString("dislike1");
				String disSid2 = rs.getString("dislike2");
				String disSid3 = rs.getNString("dislike3");
				sp.setSid(sid);
				sp.setP1(P1);
				sp.setP2(P2);
				sp.setP3(P3);
				sp.setP4(P4);
				sp.setDisSid1(disSid1);
				sp.setDisSid2(disSid2);
				sp.setDisSid3(disSid3);

				result.add(sp);

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

	public void input(StudentPreference spre) {

		// �õ�һ��studentpreference
		String sid = spre.getSid();
		String p1 = spre.getP1();
		String p2 = spre.getP2();
		String p3 = spre.getP3();
		String p4 = spre.getP4();
		String dis1 = spre.getDisSid1();
		String dis2 = spre.getDisSid2();
		String dis3 = spre.getDisSid3();

		try {

			Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
			Statement stmt = conn.createStatement();

			stmt.executeLargeUpdate("update studentpreference set " + "dislike1 = '" + dis1 + "'" + ", dislike2 = '"
					+ dis2 + "'" + ", dislike3 = '" + dis3 + "'" + ", p1 = '" + p1 + "'" + ", p2 = '" + p2 + "'"
					+ ", p3 = '" + p3 + "'" + ", p4 = '" + p4 + "'" + " where SID = '" + sid + "';");

			stmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
