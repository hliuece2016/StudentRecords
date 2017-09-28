package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.teacherDAO;
import daoFactory.DaoFactory;
import vo.studentRecord;

public class TeacherImpl implements teacherDAO {

	private Connection conn = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	private Statement st = null;

	public TeacherImpl(Connection conn) {
		this.conn = conn;
	}

	public studentRecord getById(int id) throws Exception {

		studentRecord sr = new studentRecord();
		StringBuffer buffer = new StringBuffer("select * from student_tbl where ID = " + id);
		this.pst = conn.prepareStatement(buffer.toString());
		rs = this.pst.executeQuery();

		while (rs.next()) {
			sr.setId(rs.getInt("ID"));
			sr.setName(rs.getString("NAME"));
			sr.setHomework(rs.getInt("HOMEWORK"));
			sr.setMidterm(rs.getInt("MIDTERM"));
			sr.setFinal(rs.getInt("FINAL"));
		}
		this.pst.close();

		return sr;

	}

	public void alter(studentRecord student) throws Exception {

		this.st = conn.createStatement();
		studentRecord check = DaoFactory.getStudentInstance().getByName(student.getName());
		if(check == null) {
			String sql = "INSERT INTO student_tbl VALUES(" + student.getId() + ", '" 
					+ student.getName() + "'," + student.getHomework() + ", " 
					+ student.getMidterm() + ", " + student.getFinal() + ", '" 
					+ "0000" + "');";
			st.executeUpdate(sql);
		}
		else {
			String sql = "update student_tbl set HOMEWORK = "+ student.getHomework() 
			+ ", MIDTERM = " + student.getMidterm() + ", FINAL = " + student.getFinal() 
			+ " where NAME = '" + student.getName()+"'";
		
			st.executeUpdate(sql);
		}
		st.close();

	}

	@Override
	public ArrayList<studentRecord> getAllStudent() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<studentRecord> list = new ArrayList<>();
		studentRecord sr = new studentRecord();
		StringBuffer buffer = new StringBuffer("select * from student_tbl;");
		this.pst = conn.prepareStatement(buffer.toString());
		rs = this.pst.executeQuery();

		while (rs.next()) {
			sr.setId(rs.getInt("ID"));
			sr.setName(rs.getString("NAME"));
			sr.setHomework(rs.getInt("HOMEWORK"));
			sr.setMidterm(rs.getInt("MIDTERM"));
			sr.setFinal(rs.getInt("FINAL"));
			list.add(new studentRecord(sr));
		}
		this.pst.close();

		return list;
	}


	
	
}
