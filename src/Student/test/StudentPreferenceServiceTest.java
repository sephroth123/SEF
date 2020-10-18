//package Student.test;
//
//import static org.junit.Assert.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import Student.service.StudentPreferenceService;
//import entity.StudentPreference;
//
//public class StudentPreferenceServiceTest {
//
//	@Before
//	public void setUp() throws Exception {
//	}
//
//	@After
//	public void tearDown() throws Exception {
//	}
//
//	@Test
//	public void calculatePreferencetest() {
//		StudentPreferenceService sps = new StudentPreferenceService();
//		
//		List<StudentPreference> list = new ArrayList<StudentPreference>();
//		StudentPreference s = new StudentPreference();
//		s.setP1("PR1");
//		s.setP1("PR2");
//		s.setP1("PR3");
//		s.setP1("PR4");
//		list.add(s);
//		
//		int score = sps.calculatePreference("PR1", list);
//		
//		assertEquals(4,score);
//	}
//	
//	@Test
//	public void calculatePreferencetest2() {
//		StudentPreferenceService sps = new StudentPreferenceService();
//		
//		List<StudentPreference> list = new ArrayList<StudentPreference>();
//		StudentPreference s = new StudentPreference();
//		s.setP1("PR1");
//		s.setP1("PR2");
//		s.setP1("PR3");
//		s.setP1("PR4");
//		list.add(s);
//		
//		int score = sps.calculatePreference("PR6", list);
//		
//		assertEquals(0,score);
//	}
//
//}
