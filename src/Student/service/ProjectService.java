package Student.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectService {

	ArrayList<String> projectslist;
    
	public List<String> sort(HashMap<String, Integer> map) {
		
		List<String> list = map
				.entrySet()
				.stream()
				.sorted(Comparator.comparing(e -> e.getValue()))
				.map(e -> new String(e.getKey()))
				.collect(
						Collectors.toList());
		
		return list;
	}
	
	public ArrayList<String> getProjectsList(){
		return projectslist;
	}
}
