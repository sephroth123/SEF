//package Student.test;
//
//import static org.junit.Assert.*;
//
//import java.util.HashMap;
//import java.util.List;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//
//import Student.service.ProjectService;
//
//public class ProjectServiceTest {
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
//	public void sortTest() {
//		HashMap<String, Integer> map = new HashMap<String, Integer>();
//		map.put("Pr1", 5);
//		map.put("Pr2", 7);
//		map.put("Pr3", 11);
//		map.put("Pr4", 6);
//		
//		ProjectService ps = new ProjectService();
//		
//		assertEquals("Pr1",ps.sort(map).get(0));
//	}
//
//
//}
