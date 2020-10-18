//package Student.test;
//
//import static org.junit.Assert.*;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import Student.service.InputDuplicatedExcepiton;
//import Student.service.InputNumberMixmatchException;
//import Student.service.StudentService;
//import entity.Student;
//
//public class StudentTest {
//
//	@Before
//	public void setUp() throws Exception {
//	}
//
//	@After
//	public void tearDown() throws Exception {
//	}
//
//
//	@Test
//	public void testInputDis_stu() throws InputNumberMixmatchException, InputDuplicatedExcepiton {
//		StudentService stu = new StudentService();
//		String sid = "s1";
//		String s = "s2 s3 s4";
//		stu.inputDis_stu(sid,s);
//		//assertEquals("The disliked students of " + sid +" s2s3s4", output);
//	}
//
//	@Test(expected = InputNumberMixmatchException.class)
//	public void testInputDis_stu2() throws InputNumberMixmatchException, InputDuplicatedExcepiton {
//		StudentService stu = new StudentService();
//		String sid = "s1";
//		String s = "s2 s3";
//		stu.inputDis_stu(sid, s);
//	}
//	
//	
//	@Test(expected = InputDuplicatedExcepiton.class)
//	public void testInputDis_stu3() throws InputNumberMixmatchException, InputDuplicatedExcepiton {
//		StudentService stu = new StudentService();
//		String sid = "s1";
//		String s = "s2 s2 s3";
//		stu.inputDis_stu(sid, s);
//	}
//	
//	
//	@Test
//	public void testInputRole() throws InputNumberMixmatchException, InputDuplicatedExcepiton {
//		StudentService stu = new StudentService();
//		String sid = "s1";
//		String role = "Engineer";
//		String framework = "whatever";
//		stu.inputRole(sid, role, framework);
//		
//	}
//	
//	
//	@Test
//	public void testInputPre_client() throws InputNumberMixmatchException, InputDuplicatedExcepiton {
//		StudentService stu = new StudentService();
//		String sid = "s1";
//		String s = "Pr1 Pr2 Pr3 Pr4";
//		stu.inputPre_client(sid,s);
//		
//	}
//
//	@Test(expected = InputNumberMixmatchException.class)
//	public void testInputPre_client2() throws InputNumberMixmatchException, InputDuplicatedExcepiton {
//		StudentService stu = new StudentService();
//		String sid = "s1";
//		String s = "Pr1 Pr2 Pr3";
//		stu.inputPre_client(sid, s);
//	}
//
//	@Test(expected = InputDuplicatedExcepiton.class)
//	public void testInputPre_client3() throws InputNumberMixmatchException, InputDuplicatedExcepiton {
//		StudentService stu = new StudentService();
//		String sid = "s1";
//		String s = "Pr1 Pr2 Pr2 Pr3";
//		stu.inputPre_client(sid, s);
//		
//	}
//}
