package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import utils.LoggerUtils;
import utils.preferences.UserPreferences;

public class DbSetUp {	
	final static Logger logger = LoggerUtils.getLogger(DbSetUp.class);
	
	private static final DbSetUp INSTANCE = new DbSetUp();
	private static Connection theConnection;
	private UserPreferences theUserPrefs;

	private DbSetUp(){
		theUserPrefs = new UserPreferences();
	}

	public Connection connectToDB(){
		if(theConnection == null){
			String DbFileName = theUserPrefs.getSQLiteDBFile();
			if(DbFileName == null){//TODO Add Exception for UserPreferences not found
				theUserPrefs.setSQLiteDBFile();
				DbFileName = theUserPrefs.getSQLiteDBFile();
			}
			if (DbFileName != null){
				// load the sqlite-JDBC driver using the current class loader
				try {
					Class.forName("org.sqlite.JDBC");
					theConnection = DriverManager.getConnection("jdbc:sqlite:"+DbFileName+".db");

				} catch (ClassNotFoundException e) {
					logger.error("Class Not Found - Return null");
					e.printStackTrace();
				} catch (SQLException e) {
					logger.error("SQL Exception - Return null");
					e.printStackTrace();
				}
			}			
		}
		return theConnection;
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
					+ "ID int," 			//1
					+ "THETVDBID int,"		//2
					+ "IMDBID int,"			//3
					+ "TITLE text,"			//4
					+ "DESCRIPTION text,"	//5
					+ "SEASONS int,"		//6
					+ "EPISODES int,"		//7
					+ "FOLLOWERS int,"		//8
					+ "COMMENTS int,"		//9
					+ "SIMILARS int,"		//10
					+ "CHARACTERS int,"		//11
					+ "LENGTH int,"			//12
					+ "NETWORK text,"		//13
					+ "RATING text,"		//14
					+ "STATUS text,"		//15
					+ "LANGUAGE text,"		//16
					+ "NOTETOTAL int,"		//17
					+ "NOTEMEAN int,"		//18
					+ "URL text,"			//19
					+ "LAST_USAGE datetime,"//20
					+ "primary key (ID));";
			String sqlCreateGenre = "Create table if not exists GENRE ("
					+ "ID int auto increment,"
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
				logger.debug("Execution of "+stringCreateArray[anIndex]+" : "+theResult);
				oStatus = oStatus && (theResult==0);
			}
		} catch (SQLException e) {
			oStatus = false;
			logger.error("Exception during SQL Querys");
			e.printStackTrace();
		}
		if(newConn){
			try {
				iConn.close();
			} catch (SQLException e) {
				oStatus = false;
				logger.error("Exception during Connection closing");
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

	public static DbSetUp getInstance() {
		return INSTANCE;
	}
}
