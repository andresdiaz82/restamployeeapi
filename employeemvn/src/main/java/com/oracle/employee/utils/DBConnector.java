package com.oracle.employee.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * While i decided to go for the orm approach for the db handling since it helps with preventing 
 * sql injection attacks and other features such as transaction managing and data layer decoupling 
 * from the app logic, i added this small class for the find employees query to showcase db operations
 * in a framework free approach, using singleton pattern for DB connection to ensure the db connector
 * object returns the same instance every time.
 *
 */

public class DBConnector {

	private Connection conn = null;
	
	private DBConnector() {
		if(conn == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","root");
			}catch(SQLException s) {
				System.out.println("Problems obtaining connection to database: "+s.getMessage()+" "+s.getErrorCode());
				conn = null;
			}catch(Exception e) {
				System.out.println("Problems during connection startup: "+e.getMessage());
				e.printStackTrace();
				conn = null;
			}
		}
	}

	/*Static class added for thread safe singleton pattern, since the static inner class
	 * is not loaded in memory until the getInstance method is called, this is a common 
	 * solution for recent java versions since using the synchronized approach has proven to
	 * fail when many threads try to access the instance at same time*/
	private static class DBConnHelper{
		private static final DBConnector INSTANCE = new DBConnector();
	}
	
	public boolean isConnected() {
		return conn!=null?true:false;
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	public static DBConnector getInstance() {
		return DBConnHelper.INSTANCE;
	}
	
	public void closeConnection() throws SQLException {
		if(this.isConnected()) {
			conn.close();
		}
	}
	
}
