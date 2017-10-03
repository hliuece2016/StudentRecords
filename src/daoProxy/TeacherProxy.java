package daoProxy;


import java.util.ArrayList;
import dao.teacherDAO;
import daoImpl.TeacherImpl;
import dbc.DatabaseConnection;
import vo.studentRecord;

//proxy class only does connection work.
public class TeacherProxy implements teacherDAO {

	private DatabaseConnection conn = null;
	private teacherDAO dao = null;

	public TeacherProxy() throws Exception {
		this.conn = new DatabaseConnection();
		this.dao = new TeacherImpl(conn.getConnection());
	}

	@Override
	public studentRecord getById(int id) throws Exception {
		// TODO Auto-generated method stub
		studentRecord studentRecord = this.dao.getById(id);

		this.conn.close();
		return studentRecord;
	}

	public void alter(studentRecord student) throws Exception {

		this.dao.alter(student);
		conn.close();
	}
	
	public ArrayList<studentRecord> getAllStudent() throws Exception{
		
		ArrayList<studentRecord> list = this.dao.getAllStudent();
		conn.close();
		return list;
	}

}
