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
 * Servlet implementation class ShowStudents
 */
@WebServlet("/ShowStudents")
public class ShowStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowStudentsServlet() {
        super();
    
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<studentRecord> list = new ArrayList<>();
		try {
			list = DaoFactory.getTeacherInstance().getAllStudent();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> info = new ArrayList<>();
		for(int i = 0; i < list.size(); i++) {
			String str = "<tr>";
			str += "<td>" + list.get(i).getId() + "</td>";
			str += "<td>" + list.get(i).getName() + "</td>";
			str += "<td>" + list.get(i).getHomework() + "</td>";
			str += "<td>" + list.get(i).getMidterm() + "</td>";
			str += "<td>" + list.get(i).getFinal() + "</td>";
			str += "</tr>";

			info.add(new String(str));
		}
		
		request.setAttribute("info", info);
		request.getRequestDispatcher("/showAllStudent.jsp").forward(request, response);
	}

}
