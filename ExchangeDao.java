package exchange.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import utils.DBConfig;

public class ExchangeDao {
	
   public ResultSet getTeam() {
	   Connection connection=null;
	   connection=DBConfig.getConnection();
       Statement statement =null;
       ResultSet resultSet =null;
       try{

           connection=DBConfig.getConnection();
           String sql = "select * from team;";
           statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
           
           }catch (Exception e){
                e.printStackTrace();

            }
       return resultSet;
   }
   public ResultSet getStudent() {
	   Connection connection=null;
	   connection=DBConfig.getConnection();
       Statement statement =null;
       ResultSet resultSet =null;
       try{

           connection=DBConfig.getConnection();
           String sql = "select * from student;";
           statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
           
           }catch (Exception e){
                e.printStackTrace();

            }
       return resultSet;
   }
}