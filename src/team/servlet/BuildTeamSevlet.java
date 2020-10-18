package team.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.exception.GpaException;
import team.exception.MoreThan1FemaleException;
import team.service.AssignStudentService;

@WebServlet("/BuildTeamSevlet")
public class BuildTeamSevlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	AssignStudentService service = new AssignStudentService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String projectId = request.getParameter("projectId");
			String s1 = request.getParameter("s1");
			String s2 = request.getParameter("s2");
			String s3 = request.getParameter("s3");
			String s4 = request.getParameter("s4");

			service.buildTeams(projectId, s1, s2, s3, s4);
			request.setAttribute("error", "students successfully joined the group !");
			request.getRequestDispatcher("/teamcreatesuccess.jsp").forward(request, response);

		} catch (GpaException e) {

			request.setAttribute("error", "gpa not up to standard!");
			request.getRequestDispatcher("/teamcreatesuccess.jsp").forward(request, response);
			e.printStackTrace();
		} catch (MoreThan1FemaleException e) {

			request.setAttribute("error", "Gender does not meet the requirements!");
			request.getRequestDispatcher("/teamcreatesuccess.jsp").forward(request, response);
			e.printStackTrace();
		}

	}

}
