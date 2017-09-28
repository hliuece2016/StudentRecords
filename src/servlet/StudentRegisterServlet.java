package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoFactory.DaoFactory;
import vo.studentRecord;

/**
 * Servlet implementation class StudentRegisterServlet
 */
@WebServlet("/StudentRegisterServlet")
public class StudentRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegisterServlet() {
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
		studentRecord student = new studentRecord();
		student.setName(req.getParameter("username"));
		student.setPassword(req.getParameter("password"));
		studentRecord check = null;
		try {
			check = DaoFactory.getStudentInstance().checkUsername(student.getName());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(check == null) {
			try {
				DaoFactory.getStudentInstance().register(student);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			req.setAttribute("info", "please login. " + student.getName());
			req.getRequestDispatcher("/login.jsp").forward(req, resp);;
		}
		else {
			req.setAttribute("info", "Username is used");
			req.getRequestDispatcher("/register.jsp").forward(req, resp);;
		}
	}

}
