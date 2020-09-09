package client.service;

import client.dao.FramworkDao;
import client.dao.ProjectDao;
import client.dao.ProjectRoleDao;
import client.dao.RoleDao;
import client.dao.RoleFramworkDao;
import client.exception.IdFormatIncorrectException;
import client.exception.NullInputException;
import client.utils.IDcreator;
import client.utils.Utils;
import entity.Framwork;
import entity.Project;
import entity.ProjectRole;
import entity.Role;
import entity.RoleFramework;

public class ClientService {

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
	public void buildProject(String description, String cId, String rName, String framworkName)
			throws NullInputException, IdFormatIncorrectException {

		String projectId = addProject(description, cId);
		String roleId = addRole(rName);
		String framworkId = addFramwork(framworkName);

		addProjectRole(projectId, roleId);
		addRoleFramwork(roleId, framworkId);

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

		if (!Utils.beginWith(cId, "c")) {
			throw new IdFormatIncorrectException("client");
		}

		String pId = IDcreator.projectId();
		Project p = new Project();
		p.setPid(pId);
		p.setDescription(description);
		p.setC_id(cId);

		ProjectDao dao = new ProjectDao();
		dao.save(p);

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

		String rId = IDcreator.roleId();
		Role r = new Role();
		r.setRid(rId);
		r.setrName(rName);

		RoleDao dao = new RoleDao();
		dao.save(r);

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

		Framwork f = new Framwork();

		String framworkId = IDcreator.frameworkId();

		FramworkDao fmDao = new FramworkDao();

		f.setFid(framworkId);
		f.setName(framworkName);

		fmDao.save(f);

		return framworkId;

	}

	/**
	 * using projectId and roleId to build a association between project and role.
	 * 
	 * @param projectId;
	 * @param roleId;
	 * @throws IdFormatIncorrectException
	 */
	public void addProjectRole(String projectId, String roleId) throws IdFormatIncorrectException {

		if (!Utils.beginWith(projectId, "p")) {
			throw new IdFormatIncorrectException("project");
		}

		if (!Utils.beginWith(roleId, "r")) {
			throw new IdFormatIncorrectException("roleId");
		}

		ProjectRole pr = new ProjectRole();
		pr.setId(IDcreator.projectRoleId());
		pr.setP_id(projectId);
		pr.setR_id(roleId);

		ProjectRoleDao dao = new ProjectRoleDao();
		dao.save(pr);

	}

	/**
	 * using framworkId and roleId to build a association between project and role.
	 * 
	 * @param framworkId;
	 * @param roleId;
	 * @throws IdFormatIncorrectException
	 */
	public void addRoleFramwork(String roleId, String framworkId) throws IdFormatIncorrectException {

		if (!Utils.beginWith(roleId, "r")) {
			throw new IdFormatIncorrectException("roleId");
		}

		if (!Utils.beginWith(framworkId, "f")) {
			throw new IdFormatIncorrectException("framwork");
		}

		RoleFramework rf = new RoleFramework();

		rf.setF_id(framworkId);
		rf.setR_id(roleId);
		rf.setF_id(IDcreator.roleFrameworkId());

		RoleFramworkDao dao = new RoleFramworkDao();

		dao.save(rf);

	}

}
