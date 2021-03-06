package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoFactory.DaoFactory;
import vo.studentRecord;

/**
 * Servlet implementation class TeacherSearchServlet
 */
@WebServlet("/TeacherSearchServlet")
public class TeacherSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt((String)req.getParameter("studentid"));
		studentRecord student = null;
		try {
			student = DaoFactory.getStudentInstance().getById(id);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(student == null) {
			req.setAttribute("error", "this student doesn't exist.");
			req.getRequestDispatcher("/teacher.jsp").forward(req, resp);
		}
		else {
			ArrayList<String> info = new ArrayList<>();
			info.add("<tr><td>ID:</td>" + "<td>" + student.getId() + "</td></tr>");
			info.add("<tr><td>NAME:" + "<td>" + student.getName() + "</td></tr>");
			info.add("<tr><td>HOMEWORK:" + "<td>" + student.getHomework() + "</td></tr>");
			info.add("<tr><td>MIDTERM:" + "<td>" + student.getMidterm() + "</td></tr>");
			info.add("<tr><td>FINAL:" + "<td>" + student.getFinal() + "</td></tr>");
	
			req.setAttribute("info1", info);
			req.getRequestDispatcher("/teacher.jsp").forward(req, resp);
		}
	}

}
