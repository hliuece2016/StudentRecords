package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoFactory.DaoFactory;
import daoImpl.TeacherImpl;
import dbc.DatabaseConnection;
import vo.studentRecord;

/**
 * Servlet implementation class teacherServlet
 */
@WebServlet("/teacherServlet")
public class teacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public teacherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		studentRecord student = new studentRecord();
		student.setId(Integer.parseInt(request.getParameter("studentid2")));
		student.setName(request.getParameter("studentname"));
		student.setHomework(Integer.parseInt(request.getParameter("homework")));
		student.setMidterm(Integer.parseInt(request.getParameter("midterm")));
		student.setFinal(Integer.parseInt(request.getParameter("finalexam")));

		try {
			DaoFactory.getTeacherInstance().alter(student);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<studentRecord> list = new ArrayList<>();
		try {
			list = DaoFactory.getTeacherInstance().getAllStudent();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> info2 = new ArrayList<>();
		for(int i = 0; i < list.size(); i++)
			info2.add(list.get(i).toString());
		
		request.setAttribute("info2", info2);
		request.getRequestDispatcher("/teacher.jsp").forward(request, response);
	}
}
