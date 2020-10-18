package projectmanager;

import java.util.HashMap;
import java.util.Scanner;

import entity.Student;
import entity.Team;

public class ProjectManager {

	public boolean limitFemale(Team team, HashMap<String,Student> students) {
		Boolean b=false;
		for (String key : students.keySet()) {
			System.out.println("key= "+ key + " and value= " + students.get(key));
			
			//find student
		
		if(  team.getS_id1().equals(key)||
				team.getS_id2().equals(key)||
				team.getS_id3().equals(key)||
				team.getS_id4().equals(key)) {
			
			//judge female
			
			if(students.get(key).getGender().equals("female")){
				
				b=true;
				System.out.println("there is a female in this team");
			}
			
		}
		}
		return b;
	}
	
	
	
	
	public void setPersonality(Student student) {
		System.out.println("now set the student "+student.getSid()+"'s Personality");
		System.out.println("please input between a and f");
		Scanner scanner=new Scanner(System.in);
		
		String input = scanner.nextLine();
		char letter = 0;
		
		try {
			//judge input letter number
			if(input.length()>1) {
				throw new Exception();
			}else 
				letter=input.toLowerCase().charAt(0);
			
			//judge the letter 
			if (letter>='A'&&letter<='F'||letter>='a'&&letter<='f') {
				
			}else throw new Exception();
		
		} catch (Exception e) {
			System.out.println("please input one letter between a and f !");
			
		}
		
		student.setPersonalityType(String.valueOf(letter));
		
		
	}
	
	
	
	
	
	
	public boolean limitPersonality(Team team, HashMap<String,Student> students) {
		Boolean b=false;
		for (String key : students.keySet()) {
			System.out.println("key= "+ key + " and value= " + students.get(key));
			
			//find student
			if(  team.getS_id1().equals(key)||
					team.getS_id2().equals(key)||
					team.getS_id3().equals(key)||
					team.getS_id4().equals(key)) {
			
			//judge PersonalityType
			if(students.get(key).getPersonalityType().equals("a")||
					students.get(key).getPersonalityType().equals("b")){
				b=true;
				System.out.println("there is a or b type in this team");
			}
			
		}
		}
		return b;
	}
	
	
	
	
	public boolean limitSameType(Team team, HashMap<String,Student> students) {
		Boolean limit=false;
		Boolean a=false;
		Boolean b=false;
		Boolean c=false;
		Boolean d=false;
		Boolean e=false;
		Boolean f=false;
		
		
		
		for (String key : students.keySet()) {
			System.out.println("key= "+ key + " and value= " + students.get(key));
			
			//find student
			if(  team.getS_id1().equals(key)||
					team.getS_id2().equals(key)||
					team.getS_id3().equals(key)||
					team.getS_id4().equals(key)) {
			
			//judge PersonalityType
			if(students.get(key).getPersonalityType().equals("a")){
				if(a=true) {
					limit=true;
					
				}
				a=true;
			}
			if(students.get(key).getPersonalityType().equals("b")){
				if(b=true) {
					limit=true;
					
				}
				b=true;
			}
			if(students.get(key).getPersonalityType().equals("c")){
				if(c=true) {
					limit=true;
					
				}
				c=true;
			}
			if(students.get(key).getPersonalityType().equals("d")){
				if(d=true) {
					limit=true;
					
				}
				d=true;
			}
			if(students.get(key).getPersonalityType().equals("e")){
				if(e=true) {
					limit=true;
					
				}
				e=true;
			}
			if(students.get(key).getPersonalityType().equals("f")){
				if(f=true) {
					limit=true;
					
				}
				f=true;
			}
			
		}
		}
		return limit;
	}
	
	
	
	public boolean limitExperience(Team team, HashMap<String,Student> students) {
		Boolean b=false;
		for (String key : students.keySet()) {
			System.out.println("key= "+ key + " and value= " + students.get(key));
			
			//find student
			if(  team.getS_id1().equals(key)||
					team.getS_id2().equals(key)||
					team.getS_id3().equals(key)||
					team.getS_id4().equals(key)) {
			
			//judge Experience
			if(students.get(key).getExperience()>=5){
				b=true;
				System.out.println("there is a Experience over 5 years programmer god in this team");
			}
			
		}
		}
		return b;
	}
	
	
	public boolean limitGPA(Team team, HashMap<String,Student> students) {
		Boolean b=true;
		double average=0.0;
		Boolean GPA3=false;
		int count=0;
		
		
		for (String key : students.keySet()) {
			System.out.println("key= "+ key + " and value= " + students.get(key));
			
			//find student
			if(  team.getS_id1().equals(key)||
					team.getS_id2().equals(key)||
					team.getS_id3().equals(key)||
					team.getS_id4().equals(key)) {
			
			average+=students.get(key).getGpa();
			
			
			
			//judge GPA>=3
			if(students.get(key).getGpa()>=3){
				count++;
				
			}
		}
		}
		
		average=average/4;
		
		if(average>=3.5) {
			b=false;
			System.out.println("the average GPA is over 3.5 !!!");
		}
		if(count<2) {
			b=false;
			System.out.println("the student who GPA over 3,is less than 2 !!!");
		}
		return b;
	}
	
	
	
	
	
	
	
	
	
	
	
	public void setGPA(Student student) {
		System.out.println("now set the student "+student.getSid()+"'s GPA");
		System.out.println("please input a number");
		Scanner scanner=new Scanner(System.in);
		
		String input = scanner.nextLine();
		double GPA = 0.0;
		
		try {
			GPA=Double.parseDouble(input);
			
			
		
		} catch (Exception e) {
			System.out.println("please input a number!");
			
		}
		
		student.setGpa(GPA);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
