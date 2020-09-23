package Student.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



import Student.service.ManagerService;

public class ManagerServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void rankTest() {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("pr1", 15);
		map.put("pr2", 11);
		map.put("pr3", 20);
		map.put("pr4", 14);
		ManagerService ms = new ManagerService();
	    List<String> list =  ms.rank(map);
	    System.out.println(list);
	}

}
