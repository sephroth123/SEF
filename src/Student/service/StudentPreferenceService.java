package Student.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Student.dao.StudentPreferenceDao;
import entity.StudentPreference;

public class StudentPreferenceService {

	ArrayList<StudentPreference> preference = new ArrayList<StudentPreference>();
	HashMap<String, Integer> pScore = new HashMap<String, Integer>();
	StudentPreferenceDao spdDao = new StudentPreferenceDao();

	public HashMap<String, Integer> getPreferenceScore(ArrayList<String> projectslist) {

		List<StudentPreference> preList = spdDao.getStudentPreferenceList();

		for (String projectId : projectslist) {
			int score = calculatePreference(projectId, preList);
			pScore.put(projectId, score);
		}
		return pScore;
	}

	public Integer calculatePreference(String pro_id, List<StudentPreference> preList) {

		int count = 0;
		String pid = null;

		for (StudentPreference pre : preList) {
			pid = pre.getP1();
			if (pro_id.equals(pid))
				count += 4;

			pid = pre.getP2();
			if (pro_id.equals(pid))
				count += 3;

			pid = pre.getP3();
			if (pro_id.equals(pid))
				count += 2;

			pid = pre.getP4();
			if (pro_id.equals(pid))
				count += 1;
		}
		return count;
	}

}
