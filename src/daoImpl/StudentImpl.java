package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


import dao.studentDAO;
import vo.studentRecord;

public class StudentImpl implements studentDAO {

	private Connection conn = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	private Statement st = null;

	public StudentImpl(Connection conn) {
		this.conn = conn;
	}

	public studentRecord getById(int id) throws Exception {

		studentRecord sr = null;
		StringBuffer buffer = new StringBuffer("select * from student_tbl where ID = " + id);
		this.pst = conn.prepareStatement(buffer.toString());
		rs = this.pst.executeQuery();

		if(rs == null) return sr;
		
		while (rs.next()) {
			sr = new studentRecord();
			sr.setId(rs.getInt("ID"));
			sr.setName(rs.getString("NAME"));
			sr.setHomework(rs.getInt("HOMEWORK"));
			sr.setMidterm(rs.getInt("MIDTERM"));
			sr.setFinal(rs.getInt("FINAL"));
		}
		this.pst.close();
		this.rs.close();

		return sr;

	}

	public studentRecord getByName(String name) throws Exception {
		studentRecord sr = null;
		StringBuffer buffer = new StringBuffer("select * from student_tbl where NAME = '" + name + "'");
		this.pst = conn.prepareStatement(buffer.toString());
		rs = this.pst.executeQuery();

		while (rs.next()) {
			sr = new studentRecord();
			sr.setId(rs.getInt("ID"));
			sr.setName(rs.getString("NAME"));
			sr.setHomework(rs.getInt("HOMEWORK"));
			sr.setMidterm(rs.getInt("MIDTERM"));
			sr.setFinal(rs.getInt("FINAL"));
		}
		this.pst.close();
		this.rs.close();

		return sr;
	}

	public studentRecord login(String username, String password) throws Exception {

		pst = conn.prepareStatement("SELECT * FROM student_tbl WHERE NAME=? AND password=?");
		pst.setString(1, username);
		pst.setString(2, password);
		rs = pst.executeQuery();
		studentRecord sr = new studentRecord();
		
		if (rs.next()) {
			sr.setId(rs.getInt("ID"));
			sr.setName(rs.getString("NAME"));
			sr.setHomework(rs.getInt("HOMEWORK"));
			sr.setMidterm(rs.getInt("MIDTERM"));
			sr.setFinal(rs.getInt("FINAL"));
			sr.setPassword(rs.getString("PASSWORD"));
			return sr;
		}

		return null;
	}

	public studentRecord checkUsername(String username) throws Exception {
		pst = conn.prepareStatement("select * from student_tbl where NAME = '" + username + "'");
		rs = pst.executeQuery();
		if (rs.next()) {
			return new studentRecord();
		}
		return null;
	}
	
	public boolean register(studentRecord student) throws Exception {

		this.st = conn.createStatement();
		String sql = "INSERT INTO student_tbl VALUES(" + student.getId() + ", '" + student.getName() + "',"
				+ student.getHomework() + ", " + student.getMidterm() + ", " + student.getFinal() + ", '"
				+ student.getPassword() + "');";
		st.executeUpdate(sql);

		st.close();

		return true;
	}
}
