package Student.service;

import java.util.ArrayList;
import java.util.HashMap;

import dao.StudentPreferenceDao;
import entity.StudentPreference;

public class StudentPreferenceService {

	ArrayList<StudentPreference> preference;
	HashMap<String, Integer> pScore;
	StudentPreferenceDao spd;
	
	public HashMap<String, Integer> getPreferenceScore(ArrayList<String> projectslist){
		
		getPreference();
		
		for(String pros : projectslist) {
			int score = calculatePreference(pros);
			pScore.put(pros, score);
		}
		return pScore;
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
		
		pid = pre.getP4();
		if(pro_id == pid)
			count += 1;
		}
		return count;
	}
    
    
    public ArrayList<StudentPreference> getPreference(){
    	HashMap<String, StudentPreference> map = spd.output();
    	preference = (ArrayList<StudentPreference>) map.values();
    	return preference;
    }
}
