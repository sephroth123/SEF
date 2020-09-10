package Student.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Student.service.InputDuplicatedExcepiton;
import Student.service.InputNumberMixmatchException;
import entity.Student;

public class StudentTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testInputDis_stu() throws InputNumberMixmatchException, InputDuplicatedExcepiton {
		Student stu = new Student();
		String sid = "s1";
		String output = stu.inputDis_stu(sid);
		assertEquals("The disliked students of " + sid +" s2s3s4", output);
	}

	@Test(expected = InputNumberMixmatchException.class)
	public void testInputDis_stu2() throws InputNumberMixmatchException, InputDuplicatedExcepiton {
		Student stu = new Student();
		String sid = "s1";
		String output = stu.inputDis_stu(sid);
	}
	
	
	@Test(expected = InputDuplicatedExcepiton.class)
	public void testInputDis_stu3() throws InputNumberMixmatchException, InputDuplicatedExcepiton {
		Student stu = new Student();
		String sid = "s1";
		String output = stu.inputDis_stu(sid);
	}
	
	@Test
	public void testInputRole() throws InputNumberMixmatchException, InputDuplicatedExcepiton {
		Student stu = new Student();
		String sid = "s1";
		String output = stu.inputRole(sid);
		
		assertEquals("The role preferred of " + sid + " : " + "programmerjavaanalystpython", output);
	}
	
	@Test(expected = InputNumberMixmatchException.class)
	public void testInputRole2() throws InputNumberMixmatchException, InputDuplicatedExcepiton {
		Student stu = new Student();
		String sid = "s1";
		String output = stu.inputRole(sid);
		
	}
	
	@Test(expected = InputDuplicatedExcepiton.class)
	public void testInputRole3() throws InputNumberMixmatchException, InputDuplicatedExcepiton {
		Student stu = new Student();
		String sid = "s1";
		String output = stu.inputRole(sid);
		
	}
	
	@Test
	public void testInputPre_client() throws InputNumberMixmatchException, InputDuplicatedExcepiton {
		Student stu = new Student();
		String sid = "s1";
		String output = stu.inputPre_client(sid);
		
		assertEquals("The clients preferred of " + sid + " : " + "c1c2c3c4", output);
	}

	@Test(expected = InputNumberMixmatchException.class)
	public void testInputPre_client2() throws InputNumberMixmatchException, InputDuplicatedExcepiton {
		Student stu = new Student();
		String sid = "s1";
		String output = stu.inputPre_client(sid);
	}

	@Test(expected = InputDuplicatedExcepiton.class)
	public void testInputPre_client3() throws InputNumberMixmatchException, InputDuplicatedExcepiton {
		Student stu = new Student();
		String sid = "s1";
		String output = stu.inputPre_client(sid);
		
	}
}
