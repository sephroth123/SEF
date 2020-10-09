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
	ArrayList<StudentPreference> preference;
	ArrayList<String> projects;
	HashMap<String, Integer> scoreMap;
	int stu_number;
	int pro_number;
	
	public void discard() throws LessProjectException {
		stu_number = preference.size();
		pro_number = projects.size();
		
		for(String pros : projects) {
			int score = calculatePreference(pros);
			scoreMap.put(pros, score);
		}
		
		List<String> sorted = rank(scoreMap);
		List<String>popular_pro = delect(sorted);
		
	}
	
	public List<String> delect(List<String> list) throws LessProjectException {
		
		int require_num = stu_number/4;
		
		if(pro_number > require_num) {
		 
			int delect_num = pro_number- require_num;
		 
			for(int i = 0; i < delect_num ; i++) {
				list.remove(i);
			}
		}
		else {
			throw new LessProjectException("The number of projects are less than needed.");
		}
		return list;
		
	}
	
	public List<String> rank(HashMap<String, Integer> map) {
		
		List<String> list = map
				.entrySet()
				.stream()
				.sorted(Comparator.comparing(e -> e.getValue()))
				.map(e -> new String(e.getKey()))
				.collect(
						Collectors.toList());
		
		return list;
	}
	
	public Integer calculatePreference(String pro_id) {
		
		int count = 0;
		String pid = null;
		
		for( StudentPreference pre : preference) {
		pid = pre.getP1();
		if(pro_id == pid)
			count += 4;
		
		pid = pre.getP2();
		if(pro_id == pid)
		    count += 3;
		
		pid = pre.getP3();
		if(pro_id == pid)
			count += 2;
		
		pid = pre.getP1();
		if(pro_id == pid)
			count += 1;
		}
		return count;
	}

	
}
