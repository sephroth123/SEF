package team.service;

import java.util.ArrayList;
import java.util.List;

import common.IDcreatorService;
import entity.Student;
import entity.Team;
import entity.Weight;
import team.dao.StudentDao;
import team.dao.TeamDao;
import team.dao.WeightDao;
import team.exception.GpaException;
import team.exception.MoreThan1FemaleException;

public class AssignStudentService {

	TeamDao teamDao = new TeamDao();
	StudentDao studentDao = new StudentDao();
	WeightDao weightDao = new WeightDao();
	IDcreatorService iDcreatorService = new IDcreatorService();

	public void buildTeams(String projectId, String s1, String s2, String s3, String s4)
			throws GpaException, MoreThan1FemaleException {

		List<Student> studentList = createStudentList(s1, s2, s3, s4);

		// TODO

		if (checkGpa(studentList)) {
			throw new GpaException();
		}
		if (isMoreThan1Female(studentList)) {
			throw new MoreThan1FemaleException();
		}

		int weight = caculateWeight(studentList);

		Team team = new Team();
		team.setTid(iDcreatorService.teamId());
		team.setP_id(projectId);
		team.setS_id1(s1);
		team.setS_id2(s2);
		team.setS_id3(s3);
		team.setS_id4(s4);
		team.setSatisfaction(weight);
		teamDao.save(team);

	}

	public int caculateWeight(List<Student> studentList) {

		// soft1
		int weight1 = 0;
		int weight2 = 0;
		if (check5Exp(studentList)) {

			Weight w = weightDao.listByConstraintAll("workexperience");
			if (null != w) {
				System.out.println(w);
				weight1 = w.getWeight();
			}

		}
		if (checkPersonality(studentList)) {

			Weight w = weightDao.listByConstraintAll("personalitytype");
			if (null != w) {

				System.out.println(w);
				weight2 = w.getWeight();
			}
		}

		// the number of each soft constraints is 1;
		int result = 1 * weight1 + 1 * weight2;

		return result;

	}

	/**
	 * Every team also should have one member with at least 5 years of previous work
	 * experience (soft constraint).
	 */
	public boolean check5Exp(List<Student> studentList) {

		int count = 0;
		for (Student student : studentList) {

			int exp = student.getExperience();
			if (exp >= 5) {
				count++;
			}

		}

		if (count >= 1) {
			return true;
		}

		return false;

	}

	/**
	 * For each team formed there must be at least one of personality type A or B.
	 * Moreover, no two members of the same personality types can be placed in one
	 * team (soft constraint).
	 */
	public boolean checkPersonality(List<Student> studentList) {

		int count = 0;
		for (Student student : studentList) {

			if ("A".equals(student.getPersonalityType()) || "B".equals(student.getPersonalityType())) {
				count++;
			}

			for (Student student2 : studentList) {

				boolean b1 = student.getPersonalityType().equals(student2.getPersonalityType());
				boolean b2 = student.getSid().equals(student2.getSid());
				if (b1 && !b2) {
					return false;

				}

			}

		}

		if (count < 1) {

			return false;

		}

		return true;

	}

	/**
	 * 
	 * Every team should have at least two or more students with GPA 3, while no
	 * team should have an average GPA exceeding 3.5 (hard constraints)
	 */
	public boolean checkGpa(List<Student> studentList) {

		int count = 0;
		Double sum = 0D;
		for (Student student : studentList) {

			if (student.getGpa() >= 3) {
				count++;

			}

			sum += student.getGpa();

		}

		if (count < 2) {
			return false;
		}

		if (sum / 4 > 3.5) {
			return false;
		}

		return true;

	}

	/**
	 * 
	 * no more than 1 female student is placed in one team (hard constraints)
	 */
	public boolean isMoreThan1Female(List<Student> studentList) {

		int female = 0;
		for (Student student : studentList) {

			if ("female".equals(student.getGender())) {
				female++;
			}

		}

		if (female > 1) {

			return true;
		}

		return false;

	}

	public List<Student> createStudentList(String s1, String s2, String s3, String s4) {

		List<Student> result = new ArrayList<Student>();
		Student student1 = studentDao.getByiD(s1);
		Student student2 = studentDao.getByiD(s2);
		Student student3 = studentDao.getByiD(s3);
		Student student4 = studentDao.getByiD(s4);

		result.add(student1);
		result.add(student2);
		result.add(student3);
		result.add(student4);

		return result;

	}

}
