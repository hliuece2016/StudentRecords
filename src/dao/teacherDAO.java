package dao;

import java.util.ArrayList;

import vo.studentRecord;

public interface teacherDAO {

	public studentRecord getById(int id) throws Exception;
//	public studentRecord getByName(String name) throws Exception;
	public ArrayList<studentRecord> getAllStudent() throws Exception;
//	public boolean update(studentRecord sr);
	public void alter(studentRecord sr) throws Exception;
//	public boolean delete(int id);

}
