package Student.service;

import java.util.Scanner;
import java.util.stream.Stream;

import dao.FrameworkDao;
import dao.RoleDao;
import dao.RoleFramworkDao;
import dao.StudentDao;
import dao.StudentPreferenceDao;
import dao.StudentRoleDao;
import entity.Framework;
import entity.Role;
import entity.Student;
import entity.StudentPreference;
import entity.StudentRole;

public class StudentService {
	StudentPreference stu_pre;
	//get datas from the database
	
	public void inputDis_stu(String Sid, String s) throws InputNumberMixmatchException, InputDuplicatedExcepiton {
		
		boolean flag = true;
		while(flag) {
		
		    String [] str = s.split(" ");
	        
		    if(str.length != 3) {
	    	    throw new InputNumberMixmatchException("Insert number error, you have inserted " + str.length);
	        }
	        else if(Stream.of(str).distinct().count() < str.length)
    		    throw new InputDuplicatedExcepiton("Insert duplicated!");
	        else {
	    	   
	    	    String disSid1 = str[0];
			    String disSid2 = str[1];
			    String disSid3 = str[2];
			    
			    stu_pre.setDisSid1(disSid1);
			    stu_pre.setDisSid2(disSid2);
			    stu_pre.setDisSid3(disSid3);
			    
			    flag = false;
	    	    
	        }
		}	
	
	}
	
	
	public void inputPre_client(String Sid, String p) throws InputNumberMixmatchException, InputDuplicatedExcepiton {
		
		boolean flag = true;
		while(flag) {
			
		    
		    String [] client = p.split(" ");
		
		    if(client.length != 4) {
    	        throw new InputNumberMixmatchException("Insert number error, you have inserted" + client.length);
            }
            else if(Stream.of(client).distinct().count() < client.length)
		        throw new InputDuplicatedExcepiton("Insert duplicated!");
            else {
		        String p1 = client[0];
		        String p2 = client[1];
		        String p3 = client[2];
		        String p4 = client[3];
		
		        stu_pre.setP1(p1);
		        stu_pre.setP2(p2);
		        stu_pre.setP3(p3);
		        stu_pre.setP4(p4);
		        flag = false;
           }
		}
	
	}
	
	
	public void inputRole(String sid, String r, String f) throws InputNumberMixmatchException, InputDuplicatedExcepiton {
		
		        RoleDao rd = new RoleDao();
				FrameworkDao fwd = new FrameworkDao();
				RoleFramworkDao rfwd = new RoleFramworkDao();
				StudentRoleDao srd = new StudentRoleDao();
				
				String rid = rd.input(r);
				String fid = fwd.input(f);
				String rfid = rfwd.input(rid, fid);
				srd.input(sid, rfid);

	}

	
	public void inputPreference() {
		StudentPreferenceDao spd = new StudentPreferenceDao();
		spd.input(stu_pre);
	}
	

	public Integer getStudentNumber() {
		StudentDao sd = new StudentDao();
		int stuNumber = sd.output().size();
		return stuNumber;
	}
}
