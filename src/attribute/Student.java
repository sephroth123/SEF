package attribute;

import java.util.*;
import java.util.stream.Stream;

public class Student {

	private String sid;
	private String userName;
	private String password;
	private String gender;
	private String personalityType;
	private int experience;
	private double gpa;
    
	Scanner scan = new Scanner(System.in);

	//get datas from the database
	
	public String inputDis_stu(String Sid) throws InputNumberMixmatchException, InputDuplicatedExcepiton {
		
		StudentPreference stu_pre = new StudentPreference();
		
		boolean flag;
		while(flag = true) {
			
		    System.out.println("Enter The ID of 3 students you don't want to work with, seperate by space");
		    String s = scan.nextLine();
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
			    
			    break;
	    	    
	        }
		}	
		String out = "The disliked students of " + Sid + " " +stu_pre.getDisSid1() + stu_pre.getDisSid2() + stu_pre.getDisSid3();
		System.out.println(out);
		return out;
	}
	
	
	public String inputPre_client(String Sid) throws InputNumberMixmatchException, InputDuplicatedExcepiton {
		
		StudentPreference stu_pre = new StudentPreference();
		
		boolean flag;
		while(flag = true) {
			
		    System.out.println("Enter four id of clients you preferred in the oreder preference,seperate by space. ");
		    String p = scan.nextLine();
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
		        break;
           }
		}
		String out = "The clients preferred of " + Sid + " : " + stu_pre.getP1() + stu_pre.getP2() + stu_pre.getP3() + stu_pre.getP4();
		System.out.println(out);
		return out;
	
	}
	
	
	public String inputRole(String sid) throws InputNumberMixmatchException, InputDuplicatedExcepiton {
		
		Role role1 = new Role();
		Role role2 = new Role();
		
		boolean flag;
		while(flag = true) {
		    System.out.println("Enter 2 role you wanna take along with their framework, like analyst Mysql programmer java");
		    String r = scan.nextLine();
		    String [] role = r.split(" ");
		

	        if(role.length != 4) {
	            throw new InputNumberMixmatchException("Insert number error, please complete your information.");
            }
            else if(Stream.of(role).distinct().count() < role.length)
	            throw new InputDuplicatedExcepiton("Insert duplicated!");
            else {
		        String rolename1 = role[0];
		        String framework1 = role[1];
		        String rolename2 = role[2];
		        String framework2 = role[3];
        
		        role1.setrName(rolename1);
		        role1.setFramework(framework1);
		
		        role2.setrName(rolename2);
		        role2.setFramework(framework2);
		        break;
            }
		}
		String out = "The role preferred of " + sid + " : " + role1.getrName() + role1.getFramework() + role2.getrName()  + role2.getFramework();
		System.out.println(out);
		return out;
	}
	
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPersonalityType() {
		return personalityType;
	}

	public void setPersonalityType(String personalityType) {
		this.personalityType = personalityType;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
}
