package Student.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProjectDao;

@WebServlet(name = "ProjectDiscardServlet", urlPatterns = {"/ProjectDiscardServlet"} )
public class ProjectDiscardServlet {

	private static final long serialVersionUID = 1L;
	private static final String username = null;
	private static final String password = null;
	private static final HttpServletRequest request = null;
	private static final ServletResponse response = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProjectDao pd = new ProjectDao();
		ArrayList<String> list = pd.getPidList();
		request.setAttribute("projectlist", list);
		


		//request.getRequestDispatcher("/result.jsp").forward(request, response);

	}
}
