package dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.StudentPreference;

public class StudentPreferenceDaoTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGet() {
		StudentPreferenceDao spd = new StudentPreferenceDao();
		System.out.println(spd.output());
	}

	@Test
	public void testGet2() {
		StudentPreferenceDao spd = new StudentPreferenceDao();
		
		StudentPreference spr = new StudentPreference();
		spr.setSid("S20");
		spr.setDisSid1("S1");
		spr.setDisSid2("S2");
		spr.setDisSid3("S3");
		spr.setP1("p1");
		spr.setP2("p2");
		spr.setP3("p3");
		spr.setP4("p4");
		spd.input(spr);
	}
}
