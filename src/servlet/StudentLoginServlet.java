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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class StudentLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentLoginServlet() {
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
				req.setAttribute("error", "Username or password is wrong, please relogin! \n" + username +" "+ password);
	            req.getRequestDispatcher("studentLogin.jsp").forward(req, resp);
			}
			else {
				//use session attribute to store the user name, later page may use it.
				req.getSession().setAttribute("username", username);
				req.getRequestDispatcher("student.jsp").forward(req, resp);
			}
	}

}
