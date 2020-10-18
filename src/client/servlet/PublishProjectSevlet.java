package client.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Student.dao.ProjectDao;
import client.exception.IdFormatIncorrectException;
import client.exception.NullInputException;
import client.service.ClientService;

@WebServlet("/presentation")
public class PublishProjectSevlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ClientService service = new ClientService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String description = request.getParameter("description");
			String rName = request.getParameter("rName");
			String framworkName = request.getParameter("framworkName");
			String cId = (String) request.getSession().getAttribute("userId");// TODO
			System.out.println(description);
			System.out.println(rName);
			System.out.println(framworkName);
			System.out.println(cId);
			service.publishProject(description, cId, rName, framworkName);

//			// by shuyi
//			ProjectDao pd = new ProjectDao();
//			ArrayList<String> list = pd.getPidList();
//			String projectIdString = "";
//			for (String projectId : list) {
//
//				projectIdString = projectIdString + "," + projectId;
//
//			}
//
//			request.setAttribute("projectIdString", projectIdString);
//			request.getRequestDispatcher("/projectdiscard.jsp").forward(request, response);

			request.getRequestDispatcher("/publishsuccess.jsp").forward(request, response);

		} catch (NullInputException e) {
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			e.printStackTrace();
		} catch (IdFormatIncorrectException e) {
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			e.printStackTrace();
		}

	}

}
