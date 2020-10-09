package Student.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import entity.*;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class ManagerService {

	ArrayList<String> projects;
	HashMap<String, Integer> scoreMap;
	int stu_number;
	int pro_number;
	StudentPreferenceService sps;
	ProjectService ps;
	
	public List<String> discard() throws LessProjectException {
		
		projects = ps.getProjectsList();
		scoreMap = sps.getPreferenceScore(projects);
		
		List<String> sorted = ps.sort(scoreMap);
		
		List<String>popular_pro = delete(sorted);
		return popular_pro;
	}
	
	public List<String> delete(List<String> list) throws LessProjectException {
		
		StudentService ss = new StudentService();
		stu_number = ss.getStudentNumber();
		pro_number = list.size();
		
		int require_num = stu_number/4;
		
		if(pro_number > require_num) {
		 
			int delect_num = pro_number- require_num;
	
			for(int i = 0; i < delect_num ; i++) {
				list.remove(0);
			}
		}
		else {
			throw new LessProjectException("The number of projects are less than needed.");
		}
	
		return list;
	}
	

	
	
}
