package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import bom.Episode;
import bom.Show;
import utils.LoggerUtils;

public class DbEpisode {
	
	private final static Logger logger = LoggerUtils.getLogger(DbEpisode.class);
	
	private DbSetUp aDbSetup;
	
	public DbEpisode(){
		aDbSetup = DbSetUp.getInstance();
	}
	
	public DbEpisode(DbSetUp inDbSetup){
		this.aDbSetup = inDbSetup;
	}
	
	public int selectIdEpisode(Episode inEpisode, Connection theConn){
		int theReturnId = -1;
		String sqlSelectEpisode = "Select ID from EPISODE where EPISODE.ID = ?;";
		try {
			// create the java statement
			final PreparedStatement theStatement = theConn.prepareStatement(sqlSelectEpisode);
			theStatement.setInt(1, (int) inEpisode.getId());
		    // execute the query, and get a java resultset
		    ResultSet theResults = theStatement.executeQuery();
		    if(theResults.next()){
		    	theReturnId = theResults.getInt("ID");
		    }
		} catch (SQLException e) {
			logger.error("Exception during the select request for a show.");
			e.printStackTrace();
			return theReturnId;
		}
		return theReturnId;
	}
}
