package client.service;

import client.dao.FramworkDao;
import client.dao.ProjectDao;
import client.dao.ProjectRoleDao;
import client.dao.RoleDao;
import client.dao.RoleFramworkDao;
import client.exception.IdFormatIncorrectException;
import client.exception.NullInputException;
import client.utils.IDcreatorService;
import client.utils.Utils;
import entity.Framework;
import entity.Project;
import entity.ProjectRole;
import entity.Role;
import entity.RoleFramework;

public class ClientService {

	ProjectDao projectDao = new ProjectDao();
	ProjectRoleDao projectRoleDao = new ProjectRoleDao();
	RoleFramworkDao roleFramworkDao = new RoleFramworkDao();
	FramworkDao framworkDao = new FramworkDao();
	RoleDao roleDao = new RoleDao();

	/**
	 * build new project with the input from the user.
	 * 
	 * --- the main function of this service
	 * 
	 * @param description
	 * @param cId
	 * @param rName
	 * @param framworkName
	 * @throws IdFormatIncorrectException
	 * 
	 */
	public void publishProject(String description, String cId, String rName, String framworkName)
			throws NullInputException, IdFormatIncorrectException {

		String projectId = addProject(description, cId);
		String roleId = addRole(rName);
		String framworkId = addFramwork(framworkName);
		String rfId = addRoleFramwork(roleId, framworkId);
		addProjectRole(projectId, rfId);

	}

	/**
	 * create new project;
	 * 
	 * @param description
	 * @param cId
	 * @throws IdFormatIncorrectException
	 */
	public String addProject(String description, String cId) throws NullInputException, IdFormatIncorrectException {

		if (Utils.isNull(cId)) {

			throw new NullInputException("cId");

		}

		if (Utils.isNull(description)) {

			throw new NullInputException("description");

		}

//		if (!Utils.beginWith(cId, "c")) {
//			throw new IdFormatIncorrectException("client");
//		}

		String pId = IDcreatorService.projectId();
		Project p = new Project();
		p.setPid(pId);
		p.setDescription(description);
		p.setC_id(cId);
		projectDao.save(p);

		return pId;

	}

	/**
	 * using role name to create a new role, return the newest Id of role
	 * 
	 * @return rId;
	 * @param description
	 * @param cId
	 */
	public String addRole(String rName) throws NullInputException {

		if (Utils.isNull(rName)) {

			throw new NullInputException("rName");

		}

		String rId = IDcreatorService.roleId();
		Role r = new Role(rId, rName);
		roleDao.save(r);

		return rId;

	}

	/**
	 * using role framworkName to create a new Framwork, return the newest Id of
	 * Framwork
	 * 
	 * @return fId;
	 * @param framworkName
	 */
	public String addFramwork(String framworkName) throws NullInputException {

		if (Utils.isNull(framworkName)) {

			throw new NullInputException("framworkName");

		}

		Framework f = new Framework();

		String framworkId = IDcreatorService.frameworkId();

		f.setFid(framworkId);
		f.setName(framworkName);

		framworkDao.save(f);

		return framworkId;

	}

	/**
	 * using projectId and roleId to build a association between project and role.
	 * 
	 * @param projectId;
	 * @param roleId;
	 * @throws IdFormatIncorrectException
	 */
	public void addProjectRole(String projectId, String rfId) throws IdFormatIncorrectException {

//		if (!Utils.beginWith(projectId, "p")) {
//			throw new IdFormatIncorrectException("project");
//		}
//
//		if (!Utils.beginWith(roleId, "r")) {
//			throw new IdFormatIncorrectException("roleId");
//		}

		ProjectRole pr = new ProjectRole(IDcreatorService.projectRoleId(), projectId, rfId);
		projectRoleDao.save(pr);

	}

	/**
	 * using framworkId and roleId to build a association between project and role.
	 * 
	 * @param framworkId;
	 * @param roleId;
	 * @throws IdFormatIncorrectException
	 */
	public String addRoleFramwork(String roleId, String framworkId) throws IdFormatIncorrectException {

//		if (!Utils.beginWith(roleId, "r")) {
//			throw new IdFormatIncorrectException("roleId");
//		}
//
//		if (!Utils.beginWith(framworkId, "f")) {
//			throw new IdFormatIncorrectException("framwork");
//		}

		String rfId = IDcreatorService.roleFrameworkId();

		RoleFramework rf = new RoleFramework(rfId, roleId, framworkId);

		roleFramworkDao.save(rf);

		return rfId;

	}

}
