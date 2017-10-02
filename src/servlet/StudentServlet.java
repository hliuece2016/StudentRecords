package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daoFactory.DaoFactory;
import vo.studentRecord;

@WebServlet(name = "StudentServlet", urlPatterns = { "/StudentServlet.action" })
public class StudentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession ses = req.getSession();
		String username = (String)ses.getAttribute("username");
		resp.setContentType("text/html;charset=UTF-8");

		studentRecord student = new studentRecord();
		try {
			student = new studentRecord(DaoFactory.getStudentInstance().getByName(username));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<String> info = new ArrayList<>();
		info.add("ID:" + '\t' + student.getId());
		info.add("NAME:" + '\t' + student.getName());
		info.add("HOMEWORK:" + '\t' + student.getHomework());
		info.add("MIDTERM:" + '\t' + student.getMidterm());
		info.add("FINAL:" + '\t' + student.getFinal());
		
	
		req.setAttribute("info", info);
		req.getRequestDispatcher("student.jsp").forward(req, resp);
	}

}
