package Student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Student.service.InputDuplicatedExcepiton;
import Student.service.InputNumberMixmatchException;
import Student.service.StudentService;
import dao.StudentPreferenceDao;

@WebServlet(name = "myStudentServlet", urlPatterns = {"/StudentServlet"} )
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

		try {
			service.inputDis_stu(sID, dislike);
			service.inputPre_client(sID, preference);
			service.inputRole(sID, rName1, framework1);
			service.inputRole(sID, rName2, framework2);
			
		} catch (InputNumberMixmatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InputDuplicatedExcepiton e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//request.getRequestDispatcher("/studentinfo.jsp").forward(request, response);

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
