package common;

import entity.IDcreator;

public class IDcreatorService {

	private static final String type_project = "project";
	private static final String type_role = "role";
	private static final String type_framework = "framework";
	private static final String type_projectRole = "projectRole";
	private static final String type_roleFramework = "roleFramework";
	private static final String type_studentRole = "studentRole";
	private static final String type_team = "team";

	public static String teamId() {

		return createId(type_team, "t");

	}

	public static String studentRoleId() {

		return createId(type_studentRole, "sr");

	}

	public static String projectId() {

		return createId(type_project, "pr");

	}

	public static String roleId() {

		return createId(type_role, "ro");

	}

	public static String frameworkId() {

		return createId(type_framework, "fr");

	}

	public static String projectRoleId() {

		return createId(type_projectRole, "prr");

	}

	public static String roleFrameworkId() {

		return createId(type_roleFramework, "rofr");

	}

	private static String createId(String type, String idchar) {

		IDcreator iDcreator = IDcreatorDao.getByType(type);
		if (null == iDcreator) {
			int value = 1;
			iDcreator = new IDcreator();
			iDcreator.setValue(value);
			iDcreator.setType(type);

			IDcreatorDao.add(iDcreator);

			System.out.println(" save id +" + idchar + String.valueOf(value));

			return idchar + String.valueOf(value);
		}
		int value = iDcreator.getValue();
		value++;
		String newId = idchar + String.valueOf(value);
		iDcreator.setValue(value);
		IDcreatorDao.update(iDcreator);
		return newId;

	}

}
