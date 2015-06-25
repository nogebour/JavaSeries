package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import utils.preferences.UserPreferences;

public class DbSetUp {
	private UserPreferences theUserPrefs;
	
	public DbSetUp(){
		theUserPrefs = new UserPreferences();
	}
	
	public Connection connectToDB(){
		String DbFileName = theUserPrefs.getSQLiteDBFile();
		Connection theConn = null;
		if(DbFileName == null){//TODO Add Exception for UserPreferences not found
			theUserPrefs.setSQLiteDBFile();
			DbFileName = theUserPrefs.getSQLiteDBFile();
		}
		if (DbFileName != null){
			// load the sqlite-JDBC driver using the current class loader
		    try {
				Class.forName("org.sqlite.JDBC");
				theConn = DriverManager.getConnection("jdbc:sqlite:"+DbFileName+".db");
				
			} catch (ClassNotFoundException e) {
				System.out.println("Class Not Found - Return null");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("SQL Exception - Return null");
				e.printStackTrace();
			}
		}
		return theConn;
	}
}
