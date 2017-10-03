package dbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConnection {

	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/student";
	private static final String DBUSER = "root";
	private static final String DBPASSWORD = "342516";
	private Connection conn = null;
	
	public DatabaseConnection() throws Exception{
		try{
			Class.forName(DBDRIVER);
			//conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
			//use below code to reduce warning of connection process.
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?" +
			"useUnicode=true&characterEncoding=utf-8&useSSL=false","root","342516");
		}catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
	public Connection getConnection(){
		return this.conn;
	}
	
	public void close() throws Exception{
		if(this.conn != null){
			try{
				this.conn.close();
			}catch (Exception e) {
				// TODO: handle exception
				throw e;
			}
		}
	}

}
