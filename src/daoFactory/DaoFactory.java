package daoFactory;

import dao.studentDAO;
import dao.teacherDAO;
import daoProxy.StudentProxy;
import daoProxy.TeacherProxy;

public class DaoFactory {

	public static studentDAO getStudentInstance() throws Exception {
		return new StudentProxy();
	}

	public static teacherDAO getTeacherInstance() throws Exception {
		return new TeacherProxy();
	}
}
