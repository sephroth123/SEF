package projectmanager;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.*;


import attribute.Student;
import attribute.Team;



public class ProjectManagerTest {
	
	HashMap<String,Student> students=new LinkedHashMap<String,Student>();
	Scanner scanner = new Scanner(System.in);
	Team t=new Team();
	ProjectManager p=new ProjectManager();
	
	
	@Before
	public void sss() {
	
	
	Student s1 = new Student();
	s1.setSid("s1");
	s1.setGender("male");
	s1.setExperience(2);
	s1.setGpa(3);
	s1.setPersonalityType("a");
	students.put("s1",s1 );
	
	Student s2 = new Student();
	s2.setSid("s1");
	s2.setGender("male");
	s2.setExperience(2);
	s2.setGpa(2);
	s2.setPersonalityType("b");
	students.put("s2",s2 );
	
	Student s3 = new Student();
	s3.setSid("s1");
	s3.setGender("male");
	s3.setExperience(2);
	s3.setGpa(2);
	s3.setPersonalityType("c");
	students.put("s3",s3 );
	
	Student s4 = new Student();
	s4.setSid("s1");
	s4.setGender("female");
	s4.setExperience(2);
	s4.setGpa(3);
	s4.setPersonalityType("d");
	students.put("s4",s4 );
	
	
	t.setS_id1("s1");
	t.setS_id2("s2");
	t.setS_id3("s3");
	t.setS_id4("s4");

	}
	
	
	

	
	@Test
	public void testlimitFemale() {
		boolean b=false;
		b=p.limitFemale(t,students);
		
		assertEquals(b, true);
		
		
		
	}
	
	@Test
	public void testlimitPersonality() {
		
		
		boolean b=false;
		b=p.limitPersonality(t,students);
		
		assertEquals(b, true);
		
		
	}
	
	@Test
	public void testlimitSameType() {
		
		
		boolean b=false;
		b=p.limitSameType(t,students);
		
		assertEquals(b, true);
		
		
	}
	
	@Test
	public void testlimitExperience() {
		
		
		boolean b=false;
		b=p.limitExperience(t,students);
		
		assertEquals(b, false);
		
		
	}
	
	
	@Test
	public void testlimitGPA() {
		
		
		boolean b=false;
		b=p.limitGPA(t,students);
		
		assertEquals(b, true);
		
		
		
		
	}
	
	

	
	
	
	
	
	
	
}
