package Student.service;

import java.util.stream.Stream;

import Student.dao.StudentPreferenceDao;
import common.IDcreatorService;
import entity.Framework;
import entity.Role;
import entity.RoleFramework;
import entity.StudentPreference;
import entity.StudentRole;

public class StudentService {
	
	StudentPreferenceDao StudentPreferenceDao = new StudentPreferenceDao();
	StudentPreference stu_pre = new StudentPreference();

	public void inputDis_stu(String Sid, String s) throws InputNumberMixmatchException, InputDuplicatedExcepiton {

		boolean flag = true;
		while (flag) {

			String[] str = s.split(" ");

			if (str.length != 3) {
				throw new InputNumberMixmatchException("Insert number error, you have inserted " + str.length);
			} else if (Stream.of(str).distinct().count() < str.length)
				throw new InputDuplicatedExcepiton("Insert duplicated!");
			else {

				String disSid1 = str[0];
				String disSid2 = str[1];
				String disSid3 = str[2];

				stu_pre.setDisSid1(disSid1);
				stu_pre.setDisSid2(disSid2);
				stu_pre.setDisSid3(disSid3);
				

				flag = false;

			}
		}

	}

	public void inputPre_client(String Sid, String p) throws InputNumberMixmatchException, InputDuplicatedExcepiton {

		boolean flag = true;
		while (flag) {

			String[] client = p.split(" ");

			if (client.length != 4) {
				throw new InputNumberMixmatchException("Insert number error, you have inserted" + client.length);
			} else if (Stream.of(client).distinct().count() < client.length)
				throw new InputDuplicatedExcepiton("Insert duplicated!");
			else {
				String p1 = client[0];
				String p2 = client[1];
				String p3 = client[2];
				String p4 = client[3];

				stu_pre.setP1(p1);
				stu_pre.setP2(p2);
				stu_pre.setP3(p3);
				stu_pre.setP4(p4);
				
				
				flag = false;
			}
		}

	}

	public void inputRole(String sid, String r, String f)
			throws InputNumberMixmatchException, InputDuplicatedExcepiton {
		IDcreatorService idcreator = new IDcreatorService();

		Student.dao.RoleDao rd = new Student.dao.RoleDao();
		Student.dao.FrameworkDao fwd = new Student.dao.FrameworkDao();
		Student.dao.RoleFramworkDao rfwd = new Student.dao.RoleFramworkDao();
		Student.dao.StudentRoleDao srd = new Student.dao.StudentRoleDao();

		String rid = IDcreatorService.roleId();
		Role role = new Role(rid, r);
		rd.save(role);
		//

		String fid = IDcreatorService.frameworkId();
		Framework framework = new Framework();
		framework.setFid(fid);
		framework.setName(f);
		fwd.save(framework);

		String rfid = IDcreatorService.roleFrameworkId();

		RoleFramework roleFramework = new RoleFramework(rfid, rid, fid);
		rfwd.save(roleFramework);

		StudentRole studentrole = new StudentRole();
		String srid = IDcreatorService.studentRoleId();
		studentrole.setId(srid);
		studentrole.setRf_id(rfid);
		studentrole.setS_id(sid);
		srd.save(studentrole);

	}

	public void inputPreference() {
		Student.dao.StudentPreferenceDao spd = new Student.dao.StudentPreferenceDao();
		spd.input(stu_pre);
	}

	public Integer getStudentNumber() {
		Student.dao.StudentDao sd = new Student.dao.StudentDao();
		int stuNumber = sd.getAllStudentNumber();
		return stuNumber;
	}
}
