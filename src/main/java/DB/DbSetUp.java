package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

	public boolean initiateDataBase(Connection iConn){
		boolean oStatus = true;
		boolean newConn = false;
		if(iConn == null){
			iConn = connectToDB();
			newConn = true;
		}
		try {
			String sqlCreateShow = "Create table if not exists SHOW ("
					+ "ID int,"
					+ "THETVDBID int,"
					+ "IMDBID int,"
					+ "TITLE text,"
					+ "DESCRIPTION text,"
					+ "SEASONS int,"
					+ "EPISODES int,"
					+ "FOLLOWERS int,"
					+ "COMMENTS int,"
					+ "SIMILARS int,"
					+ "CHARACTERS int,"
					+ "LENGTH int,"
					+ "NETWORK text,"
					+ "RATING int,"
					+ "STATUS int,"
					+ "LANGUAGE text,"
					+ "NOTETOTAL int,"
					+ "NOTEMEAN int,"
					+ "URL STRING,"
					+ "primary key (ID));";
			ResultSet theResultSet = executeSqlQuery(iConn, sqlCreateShow);
			String sqlCreateMember = "Create table Member ";
		} catch (SQLException e) {
			oStatus = false;
			System.out.println("Exception during SQL Querys");
			e.printStackTrace();
		}
		if(newConn){
			try {
				iConn.close();
			} catch (SQLException e) {
				oStatus = false;
				System.out.println("Exception during Connection closing");
				e.printStackTrace();
			}
		}
		return oStatus;
	}

	private ResultSet executeSqlQuery(Connection iConn, String sqlQuery)
			throws SQLException {
		Statement theStmt = iConn.createStatement();
		return theStmt.executeQuery(sqlQuery);
	}
}
