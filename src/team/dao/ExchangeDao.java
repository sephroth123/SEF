package team.dao;

import common.configration.DBConfig;
import entity.Student;
import entity.Team;


import java.sql.*;
import java.util.ArrayList;

public class ExchangeDao {


	//Query the team data public method
	public ArrayList findTeamBySql(String sql) throws SQLException {
		ArrayList<Team> teamList = new ArrayList<Team>();
		Connection connection = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery(sql);
		while (resultSet.next()){
			Team team=new Team();
			team.setP_id(resultSet.getString("PID"));
			team.setS_id1(resultSet.getString("SID1"));
			team.setS_id2(resultSet.getString("SID2"));
			team.setS_id3(resultSet.getString("SID3"));
			team.setS_id4(resultSet.getString("SID4"));
			teamList.add(team);
		}
		connection.close();
		statement.close();
		return  teamList;
	}
	//Query the student data public method
	public ArrayList findStudentBySql(String sql) throws SQLException {
		ArrayList<Student> studentsList = new ArrayList<>();
		Connection connection = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery(sql);
		while (resultSet.next()){
			Student student=new Student();
			student.setSid(resultSet.getString("SID"));
			student.setGender(resultSet.getString("gender"));
			student.setPersonalityType(resultSet.getString("pType"));
			student.setExperience(resultSet.getInt("experence"));
			student.setGpa(resultSet.getDouble("GPA"));
			studentsList.add(student);
		}
		connection.close();
		statement.close();
		return  studentsList;
	}



	//update public method
	public void updateTeamBysql(String sql) throws SQLException{
		Connection connection = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USERNAME, DBConfig.DB_PASSWORD);
		Statement statement=connection.createStatement();
		statement.execute(sql);
		connection.close();
		statement.close();
	}
}