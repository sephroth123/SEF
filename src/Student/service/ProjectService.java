package Student.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import Student.dao.ProjectDao;
import entity.Project;
import entity.Weight;
import team.dao.WeightDao;

public class ProjectService {

	ProjectDao dao = new ProjectDao();
	WeightDao weightDao = new WeightDao();

	ArrayList<String> projectslist;

	public List<String> sort(HashMap<String, Integer> map) {

		List<String> list = map.entrySet().stream().sorted(Comparator.comparing(e -> e.getValue()))
				.map(e -> new String(e.getKey())).collect(Collectors.toList());

		return list;
	}

	public ArrayList<String> getProjectsList() {

		return dao.getPidList();
	}

	public List<Project> listAll() {

		return dao.listAll();

	}

	/******* weight *******/
	public List<Weight> listAllWeight() {

		return weightDao.listAll();

	}

	public void upateWeight(String wId, int weight) {

		weightDao.update(wId, weight);

	}
}
