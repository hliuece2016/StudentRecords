package dao;

import vo.studentRecord;

public interface studentDAO {
	//define student operation
	public studentRecord getById(int id) throws Exception;
	public studentRecord getByName(String name) throws Exception;
	public studentRecord login(String username, String password) throws Exception;
	public studentRecord checkUsername(String username) throws Exception;
	public boolean register(studentRecord student) throws Exception;
	public boolean changePass(String name, String password) throws Exception;
}
