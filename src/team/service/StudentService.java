package team.service;

import java.util.List;

import entity.Student;
import team.dao.StudentDao;

public class StudentService {

	StudentDao dao = new StudentDao();

	public List<Student> listAll() {

		return dao.listAll();

	}

}
