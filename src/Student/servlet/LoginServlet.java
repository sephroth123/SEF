package Student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Student.service.StudentService;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
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

		
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		request.setAttribute("error", "wrong password!");

		request.getRequestDispatcher("/result.jsp").forward(request, response);

	}

}
