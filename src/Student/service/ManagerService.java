package Student.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Student.dao.ProjectDao;
import entity.Project;

public class ManagerService {

	StudentPreferenceService sps = new StudentPreferenceService();
	ProjectService ps = new ProjectService();
	ProjectDao pDao = new ProjectDao();

	public List<String> discard() throws LessProjectException {

		ArrayList<String> projects = ps.getProjectsList();
		HashMap<String, Integer> scoreMap = sps.getPreferenceScore(projects);

		List<String> sorted = ps.sort(scoreMap);

		List<String> popular_pro = delete(sorted);
		return popular_pro;
	}

	public Project listById(String id) {

		return pDao.getById(id);

	}

	public List<String> delete(List<String> list) throws LessProjectException {

		StudentService ss = new StudentService();
		int stu_number = ss.getStudentNumber();
		int pro_number = list.size();

		int require_num = stu_number / 4;

		if (pro_number > require_num) {

			int delect_num = pro_number - require_num;

			for (int i = 0; i < delect_num; i++) {
				list.remove(0);
			}
		} else {
			throw new LessProjectException("The number of projects are less than needed.");
		}

		return list;
	}

}
