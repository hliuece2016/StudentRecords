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
 * Servlet implementation class TeacherLoginServlet
 */
@WebServlet("/TeacherLoginServlet")
public class TeacherLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherLoginServlet() {
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
		String username = (String)req.getParameter("username");
		String password = (String)req.getParameter("password");
		studentRecord student = null;
		try {
			student = DaoFactory.getStudentInstance().login(username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(student == null) {
			req.setAttribute("error", "Username or password is wrong, please relogin! " + username +" "+ password);
            req.getRequestDispatcher("teacherLogin.jsp").forward(req, resp);
		}
		else {
			req.getRequestDispatcher("teacher.jsp").forward(req, resp);;
		}
	}

}
