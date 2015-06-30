package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import junit.framework.Assert;
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
					+ "URL text,"
					+ "LAST_USAGE datetime,"
					+ "primary key (ID));";
			String sqlCreateGenre = "Create table if not exists GENRE ("
					+ "ID int,"
					+ "GENRE text,"
					+ "primary key (ID));";
			String sqlCreateShowGenreMapping = "Create table if not exists SHOW_GENRE_MAPPING ("
					+ "ID_SHOW int,"
					+ "ID_GENRE int,"
					+ "primary key (ID_SHOW, ID_GENRE),"
					+ "foreign key (ID_SHOW) references SHOW(ID),"
					+ "foreign key (ID_GENRE) references GENRE(ID));";
			String sqlCreateEpisode = "Create table if not exists EPISODE ("
					+ "ID int,"
					+ "THETVDBID int,"
					+ "TITLE text,"
					+ "SEASON int,"
					+ "EPISODE int,"
					+ "ID_SHOW int,"
					+ "CODE text,"
					+ "GLOBAL_NUMBER int,"
					+ "DESCRIPTION text,"
					+ "AIRING_DATE datetime,"
					+ "LAST_USAGE datetime,"
					+ "foreign key (ID_SHOW) references SHOW(ID),"
					+ "primary key (ID));";
			String sqlCreateMember = "Create table if not exists MEMBER ("
					+ "ID int,"
					+ "PSEUDO text,"
					+ "TOKEN text,"
					+ "primary key (ID));";
			String sqlCreateMemberShow = "Create table if not exists MEMBER_SHOW ("
					+ "ID int auto_increment,"
					+ "ID_MEMBER int,"
					+ "ID_SHOW int,"
					+ "NOTE int,"
					+ "LAST_USAGE datetime,"
					+ "primary key (ID),"
					+ "foreign key (ID_MEMBER) references MEMBER(ID),"
					+ "foreign key (ID_SHOW) references SHOW(ID));";
			String sqlCreateRemainingEpisodes = "Create table if not exists REMAINING_EPISODES ("
					+ "ID int,"
					+ "ID_MEMBER_SHOW int,"
					+ "ID_EPISODE int,"
					+ "foreign key (ID_MEMBER_SHOW) references MEMBER_SHOW (ID),"
					+ "foreign key (ID_EPISODE) references EPISODE (ID),"
					+ "primary key (ID));";
			String[] sqlCreateArray = {sqlCreateShow,
					sqlCreateGenre,
					sqlCreateShowGenreMapping,
					sqlCreateEpisode,
					sqlCreateMember,
					sqlCreateMemberShow,
					sqlCreateRemainingEpisodes};
			String[] stringCreateArray = {"sqlCreateShow",
					"sqlCreateGenre",
					"sqlCreateShowGenreMapping",
					"sqlCreateEpisode",
					"sqlCreateMember",
					"sqlCreateMemberShow",
					"sqlCreateRemainingEpisodes"};
			for(int anIndex = 0; anIndex < sqlCreateArray.length; ++anIndex){
				int theResult = executeSqlQueryUpdate(iConn, sqlCreateArray[anIndex]);
				System.out.println("Execution of "+stringCreateArray[anIndex]+" : "+theResult);
				Assert.assertTrue(theResult == 0);
			}
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

	private int executeSqlQueryUpdate(Connection iConn, String sqlQuery)
			throws SQLException {
		Statement theStmt = iConn.createStatement();
		return theStmt.executeUpdate(sqlQuery);
	}

	private ResultSet executeSqlQuery(Connection iConn, String sqlQuery)
			throws SQLException {
		Statement theStmt = iConn.createStatement();
		return theStmt.executeQuery(sqlQuery);
	}
}
