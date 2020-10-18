package team.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import entity.Student;
import team.service.AssignStudentService;

public class AssignStudentServiceTest {

	AssignStudentService service = new AssignStudentService();

	@Test
	public void testCheck5Exp1() {

		Student s1 = new Student();
		s1.setExperience(1);
		Student s2 = new Student();
		s2.setExperience(1);
		Student s3 = new Student();
		s3.setExperience(1);
		Student s4 = new Student();
		s4.setExperience(1);
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		boolean b = service.check5Exp(studentList);
		assertEquals(false, b);

	}

	@Test
	public void testCheck5Exp2() {

		Student s1 = new Student();
		s1.setExperience(4);
		Student s2 = new Student();
		s2.setExperience(4);
		Student s3 = new Student();
		s3.setExperience(4);
		Student s4 = new Student();
		s4.setExperience(4);
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		boolean b = service.check5Exp(studentList);
		assertEquals(false, b);

	}

	@Test
	public void testCheck5Exp3() {

		Student s1 = new Student();
		s1.setExperience(5);
		Student s2 = new Student();
		s2.setExperience(1);
		Student s3 = new Student();
		s3.setExperience(1);
		Student s4 = new Student();
		s4.setExperience(1);
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		boolean b = service.check5Exp(studentList);
		assertEquals(true, b);

	}

	@Test
	public void testCheck5Exp4() {

		Student s1 = new Student();
		s1.setExperience(5);
		Student s2 = new Student();
		s2.setExperience(5);
		Student s3 = new Student();
		s3.setExperience(1);
		Student s4 = new Student();
		s4.setExperience(1);
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		boolean b = service.check5Exp(studentList);
		assertEquals(true, b);

	}

	@Test
	public void testCheckPersonality1() {

		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		Student s4 = new Student();
		s1.setPersonalityType("A");
		s2.setPersonalityType("C");
		s3.setPersonalityType("D");
		s4.setPersonalityType("E");
		s1.setSid("s1");
		s2.setSid("s2");
		s3.setSid("s3");
		s4.setSid("s4");
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		boolean b = service.checkPersonality(studentList);
		assertEquals(true, b);

	}

	@Test
	public void testCheckPersonality2() {

		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		Student s4 = new Student();
		s1.setPersonalityType("B");
		s2.setPersonalityType("C");
		s3.setPersonalityType("D");
		s4.setPersonalityType("E");
		s1.setSid("s1");
		s2.setSid("s2");
		s3.setSid("s3");
		s4.setSid("s4");
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		boolean b = service.checkPersonality(studentList);
		assertEquals(true, b);

	}

	@Test
	public void testCheckPersonality3() {

		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		Student s4 = new Student();
		s1.setPersonalityType("A");
		s2.setPersonalityType("A");
		s3.setPersonalityType("D");
		s4.setPersonalityType("E");
		s1.setSid("s1");
		s2.setSid("s2");
		s3.setSid("s3");
		s4.setSid("s4");
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		boolean b = service.checkPersonality(studentList);
		assertEquals(false, b);

	}

	@Test
	public void testCheckPersonality4() {

		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		Student s4 = new Student();
		s1.setPersonalityType("F");
		s2.setPersonalityType("C");
		s3.setPersonalityType("D");
		s4.setPersonalityType("E");
		s1.setSid("s1");
		s2.setSid("s2");
		s3.setSid("s3");
		s4.setSid("s4");
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		boolean b = service.checkPersonality(studentList);
		assertEquals(false, b);

	}

	@Test
	public void testCheckGpa1() {
		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		Student s4 = new Student();
		s1.setGpa(3);
		s2.setGpa(4);
		s3.setGpa(1);
		s4.setGpa(2);
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		boolean b = service.checkGpa(studentList);
		assertEquals(true, b);

	}

	@Test
	public void testCheckGpa2() {
		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		Student s4 = new Student();
		s1.setGpa(3);
		s2.setGpa(2);
		s3.setGpa(1);
		s4.setGpa(2);
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		boolean b = service.checkGpa(studentList);
		assertEquals(false, b);

	}

	@Test
	public void testCheckGpa3() {
		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		Student s4 = new Student();
		s1.setGpa(3);
		s2.setGpa(4);
		s3.setGpa(5);
		s4.setGpa(6);
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		boolean b = service.checkGpa(studentList);
		assertEquals(false, b);

	}

	@Test
	public void testCheckGpa4() {
		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		Student s4 = new Student();
		s1.setGpa(4);
		s2.setGpa(4);
		s3.setGpa(1);
		s4.setGpa(2);
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		boolean b = service.checkGpa(studentList);
		assertEquals(true, b);

	}

	@Test
	public void testIsMoreThan1Female1() {

		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		Student s4 = new Student();
		s1.setGender("male");
		s2.setGender("male");
		s3.setGender("male");
		s4.setGender("male");
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		boolean b = service.isMoreThan1Female(studentList);
		assertEquals(false, b);

	}

	@Test
	public void testIsMoreThan1Female2() {

		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		Student s4 = new Student();
		s1.setGender("male");
		s2.setGender("male");
		s3.setGender("male");
		s4.setGender("female");
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		boolean b = service.isMoreThan1Female(studentList);
		assertEquals(false, b);

	}

	@Test
	public void testIsMoreThan1Female3() {

		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		Student s4 = new Student();
		s1.setGender("male");
		s2.setGender("male");
		s3.setGender("female");
		s4.setGender("female");
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		boolean b = service.isMoreThan1Female(studentList);
		assertEquals(true, b);

	}

	@Test
	public void testIsMoreThan1Female4() {

		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		Student s4 = new Student();
		s1.setGender("male");
		s2.setGender("female");
		s3.setGender("female");
		s4.setGender("female");
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		boolean b = service.isMoreThan1Female(studentList);
		assertEquals(true, b);

	}

}
