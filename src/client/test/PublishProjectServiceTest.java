package client.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import client.exception.IdFormatIncorrectException;
import client.exception.NullInputException;
import client.service.ClientService;

public class PublishProjectServiceTest {

	ClientService service;

	@Before
	public void InitializationData() {

		service = new ClientService();

	}

	@Test
	public void testAddProject() throws NullInputException, IdFormatIncorrectException {

		String cid = "c01";
		String description = "xxxx";
		service.addProject(description, cid);

		assertEquals("", "");

	}

	@Test(expected = NullInputException.class)
	public void testAddProject1() throws NullInputException, IdFormatIncorrectException {

		String cid = "c01";
		String description = "";
		service.addProject(description, cid);

	}

	@Test(expected = NullInputException.class)
	public void testAddProject2() throws NullInputException, IdFormatIncorrectException {

		String cid = "";
		String description = "xxx";
		service.addProject(description, cid);

	}

	@Test(expected = IdFormatIncorrectException.class)
	public void testAddProject3() throws NullInputException, IdFormatIncorrectException {

		String cid = "01";
		String description = "xxx";
		service.addProject(description, cid);

	}

	@Test
	public void testAddRole() throws NullInputException {

		String rName = "xxx";
		service.addRole(rName);

	}

	@Test(expected = NullInputException.class)
	public void testAddRole1() throws NullInputException {

		String rName = "";
		service.addRole(rName);

	}

	@Test
	public void testAddFramwork() throws NullInputException {

		String framworkName = "xxx";
		service.addFramwork(framworkName);

	}

	@Test(expected = NullInputException.class)
	public void testAddFramwork1() throws NullInputException {
		String framworkName = "";
		service.addFramwork(framworkName);

	}

	@Test
	public void testAddProjectRole() throws IdFormatIncorrectException {

		String projectId = "p01";
		String roleId = "r01";
		service.addProjectRole(projectId, roleId);
	}

	@Test(expected = IdFormatIncorrectException.class)
	public void testAddProjectRole1() throws IdFormatIncorrectException {

		String projectId = "01";
		String roleId = "r01";
		service.addProjectRole(projectId, roleId);
	}

	@Test(expected = IdFormatIncorrectException.class)
	public void testAddProjectRole2() throws IdFormatIncorrectException {

		String projectId = "p01";
		String roleId = "01";
		service.addProjectRole(projectId, roleId);
	}

	@Test
	public void testaddRoleFramwork() throws IdFormatIncorrectException {

		String roleId = "r01";
		String framworkId = "f01";
		service.addRoleFramwork(roleId, framworkId);
	}

	@Test(expected = IdFormatIncorrectException.class)
	public void testaddRoleFramwork1() throws IdFormatIncorrectException {

		String roleId = "01";
		String framworkId = "f01";
		service.addRoleFramwork(roleId, framworkId);
	}

	@Test(expected = IdFormatIncorrectException.class)
	public void testaddRoleFramwork2() throws IdFormatIncorrectException {

		String roleId = "r01";
		String framworkId = "01";
		service.addRoleFramwork(roleId, framworkId);
	}

}
