package client.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.exception.IdFormatIncorrectException;
import client.exception.NullInputException;
import client.service.ClientService;

@WebServlet("/presentation")
public class PublishProjectSevlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ClientService service = new ClientService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String description = request.getParameter("description");
		String cId = request.getParameter("cId");
		String rName = request.getParameter("rName");
		String framworkName = request.getParameter("framworkName");

		try {

			service.buildProject(description, cId, rName, framworkName);

		} catch (NullInputException e) {
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			e.printStackTrace();
		} catch (IdFormatIncorrectException e) {
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			e.printStackTrace();
		}

		request.setAttribute("description", description);
		request.getRequestDispatcher("/projectdetail.jsp").forward(request, response);

	}

}
