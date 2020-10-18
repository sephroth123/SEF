package common;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Student.service.ProjectService;
import entity.Project;
import entity.Student;
import entity.Weight;
import team.service.StudentService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String username = null;
	private static final String password = null;
	private static final HttpServletRequest request = null;
	private static final ServletResponse response = null;
	ProjectService service = new ProjectService();
	StudentService studentService = new StudentService();

	@Override
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String userType = request.getParameter("userType");

		switch (userType) {

		// client
		case "1":
//			request.setAttribute("error", "");
			request.getSession().setAttribute("userId", "c1");// TODO
			request.getRequestDispatcher("/presentation.jsp").forward(request, response);
			break;

		// student
		case "2":

			request.getSession().setAttribute("userId", "s1");// TODO
			request.getRequestDispatcher("/studentinfo.jsp").forward(request, response);
			break;
		case "3":

			List<Weight> weightList = service.listAllWeight();
			List<Project> projectList = service.listAll();
			List<Student> studentList = studentService.listAll();
			request.getSession().setAttribute("userId", "m1");// TODO
			request.setAttribute("projectList", projectList);
			request.setAttribute("studentList", studentList);
			request.setAttribute("weightList", weightList);
			request.getRequestDispatcher("/management.jsp").forward(request, response);
			break;

		}

	}
}