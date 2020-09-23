package Student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Student.service.StudentService;

@WebServlet("/studentinfo")
public class StudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private StudentService service = new StudentService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String dislike = request.getParameter("dis_stu");
		String sID = request.getParameter("sid");
		String preference = request.getParameter("preference");
		String rName1 = request.getParameter("rName1");
		String framework1 = request.getParameter("framework1");
		String rName2 = request.getParameter("rName2");
		String framework2 = request.getParameter("framework2");

		service.buildProject(sID,dislike,preference,rName1,framework1,rName2,framework2);

		request.getRequestDispatcher("/studentinfo.jsp").forward(request, response);

	}

}
