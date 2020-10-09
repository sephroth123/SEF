package client.dao;
import entity.*;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import client.utils.*;
public class StudentDao {
	
	
	public HashMap<String,Student> getAllStudent() {
		
		
		HashMap<String,Student> students=new LinkedHashMap<String,Student>();
		DBConfig c=new DBConfig();
		Student s=new Student();
		String id = null;
		try {
			Statement stmt =c.getConnection().createStatement();
			
			String sql;
	        sql = "SELECT SID,sName,sPassword,gender,pType,experence,GPA FROM student";
	        ResultSet rs = stmt.executeQuery(sql);
	    
	        
	        while(rs.next()){
	        	id=rs.getString("SID");
	        	s.setSid(id);
	        	s.setGender(rs.getString("gender"));
	        	s.setUserName(rs.getString("sName"));
	        	s.setPersonalityType(rs.getString("pType"));
	        	s.setPassword(rs.getString("sPassword"));
	        	s.setGpa(rs.getInt("GPA"));
	        	s.setExperience(rs.getString("experence"));
//	        	s.setDisSid1(disSid1);
//	        	s.setDisSid2(disSid2);
//	        	s.setDisSid3(disSid3);
	           
	        	
	            students.put(id,s);
	            
	        }
	        
	        rs.close();
	        stmt.close();
	        
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return students;
	}
	
	
	public void setSQL() {

		HashMap<String,Student> students=new LinkedHashMap<String,Student>();
	     
	     
	     DBConfig c=new DBConfig();
	 	Student s=new Student();
	 	
	     
	     try {
	    	 
	    	 for (Entry<String, Student> entry : students.entrySet()) {
	    		 System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
	    		 
	    		 //INSERT into student(id,type,conflict1,conflict2,P,N,A,W) 
	    		 //values('s2','b','s15','s16',3,2,1,4)
	    		 
	    	 String sql="replace into student(SID,sName,sPassword,gender,pType,experence,GPA) values("+"'"+
	    			 entry.getValue().getSid()+"','"+
	    			 s.getGender()+"','"+
		        	s.getUserName()+"','"+
		        	s.getPersonalityType()+"','"+
		        	s.getPassword()+"',"+
		        	s.getGpa()+","+
		        	s.getExperience()+")";
	//	        	s.getDisSid1(disSid1);
	//	        	s.getDisSid2(disSid1);
	//	        	s.getDisSid3(disSid1);
	    	
	    	
	         
	         
	         
	         
	         Statement stmt =c.getConnection().createStatement();
	         stmt.executeUpdate(sql);
	         System.out.println("suceess");
	         stmt.close();
	     
	         
	         
	    	 }
	     } catch (SQLException e) {
	 		// TODO Auto-generated catch block
	 		e.printStackTrace();
	 	}catch (Exception e) {
	         e.printStackTrace();
	         
	     }

		
		
		
		
		
	}
	
}
