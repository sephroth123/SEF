package client.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {
    private static Connection connection=null;
    private static String address="jdbc:mysql://localhost:3306/ap?useSSL=false&serverTimezone=UTC";
    private static String DateBaseName="root";
    private static String DateBasepassword="1234";

    public static Connection getConnection(){
		    if (connection==null){
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		        }
		        catch (ClassNotFoundException e){
		
		        }
		        try{
		            connection= DriverManager.getConnection(address,DateBaseName,DateBasepassword);
		        }
		        catch (Exception e1){
		            e1.printStackTrace();
		            System.out.println("connect fail");
		        }
		
		    }
		    return connection;
		}
    
    
}


