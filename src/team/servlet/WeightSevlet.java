package team.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Student.service.ProjectService;
import entity.Project;
import entity.Student;
import entity.Weight;
import team.service.StudentService;

@WebServlet("/weightServlet")
public class WeightSevlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	ProjectService service = new ProjectService();
	StudentService studentService = new StudentService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String wId = request.getParameter("wId");
		String weight = request.getParameter("weight");
		service.upateWeight(wId, Integer.valueOf(weight));

		List<Weight> weightList = service.listAllWeight();
		List<Project> projectList = service.listAll();
		List<Student> studentList = studentService.listAll();
		request.getSession().setAttribute("userId", "m1");// TODO
		request.setAttribute("projectList", projectList);
		request.setAttribute("studentList", studentList);
		request.setAttribute("weightList", weightList);
		request.getRequestDispatcher("/management.jsp").forward(request, response);

	}

}
