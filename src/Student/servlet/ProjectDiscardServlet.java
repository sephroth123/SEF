package Student.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Student.service.LessProjectException;
import Student.service.ManagerService;
import Student.service.ProjectService;
import entity.Project;
import entity.Student;
import team.service.StudentService;

@WebServlet("/ProjectDiscardServlet")
public class ProjectDiscardServlet extends HttpServlet {

	ManagerService mService = new ManagerService();
	ProjectService pService = new ProjectService();
	StudentService studentService = new StudentService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			List<Student> studentList = studentService.listAll();

			// by shuyi
			List<String> list = mService.discard();

			List<Project> projectList = new ArrayList<Project>();
			for (String projectId : list) {

				Project p = mService.listById(projectId);
				projectList.add(p);

			}

			request.setAttribute("projectList", projectList);
			request.setAttribute("studentList", studentList);
			request.getRequestDispatcher("/management.jsp").forward(request, response);

		} catch (LessProjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
