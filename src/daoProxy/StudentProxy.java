package daoProxy;

import dao.studentDAO;
import daoImpl.StudentImpl;
import dbc.DatabaseConnection;
import vo.studentRecord;

public class StudentProxy implements studentDAO {

	private DatabaseConnection conn = null;
	private studentDAO dao = null;

	public StudentProxy() throws Exception {
		conn = new DatabaseConnection();
		this.dao = new StudentImpl(conn.getConnection());
	}

	@Override
	public studentRecord getById(int id) throws Exception {
		// TODO Auto-generated method stub
		studentRecord studentRecord = this.dao.getById(id);

		this.conn.close();
		return studentRecord;
	}
	
	public studentRecord getByName(String name) throws Exception{
		studentRecord studentRecord = this.dao.getByName(name);
		this.conn.close();
		return studentRecord;
	}
	
	public studentRecord login(String username, String password) throws Exception{
		studentRecord studentRecord = this.dao.login(username, password);
		
		this.conn.close();
		return studentRecord;
	}

	@Override
	public studentRecord checkUsername(String username) throws Exception {
		// TODO Auto-generated method stub
		studentRecord student = this.dao.checkUsername(username);
		
		this.conn.close();
		return student;
	}

	@Override
	public boolean register(studentRecord student) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = this.dao.register(student);
		this.conn.close();
		
		return flag;
	}

}
