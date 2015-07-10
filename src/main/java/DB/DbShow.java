package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.javatuples.Pair;

import utils.LoggerUtils;
import bom.Show;

public class DbShow {

	private final static Logger logger = LoggerUtils.getLogger(DbShow.class);
	
	private DbSetUp aDbSetup;
	
	public DbShow(){
		aDbSetup = DbSetUp.getInstance();
	}
	
	public DbShow(DbSetUp inDbSetup){
		this.aDbSetup = inDbSetup;
	}
	
	public int addShow(Show inShow){
		return addShow(inShow, aDbSetup.connectToDB());
	}
	
	public int addShow(Show inShow, Connection theConn){
		int theReturnId = -1;
		theReturnId = selectIdShow(inShow, theConn);
		if(theReturnId == -1){
			insertShowDb(inShow, theConn);
			theReturnId = selectIdShow(inShow, theConn);
		}
		return theReturnId;
	}

	protected void insertShowDb(Show inShow, Connection theConn) {
		String sqlInsertGenre = "Insert into SHOW (ID,THETVDBID,IMDBID,"
				+ "TITLE,DESCRIPTION,SEASONS,EPISODES,FOLLOWERS,COMMENTS,"
				+ "SIMILARS,CHARACTERS,LENGTH,NETWORK,RATING,STATUS,LANGUAGE,"
				+ "NOTETOTAL,NOTEMEAN,URL) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		try {
			PreparedStatement theStatement = theConn.prepareStatement(sqlInsertGenre);
			theStatement.setInt(1, (int) inShow.getId());
			theStatement.setInt(2, (int) inShow.getTheTvDbId());
			theStatement.setInt(3, (int) inShow.getImdbId());
			theStatement.setString(4, inShow.getTitle());
			theStatement.setString(5, inShow.getDescription());
			theStatement.setInt(6, inShow.getSeasons());
			theStatement.setInt(7, inShow.getEpisodes());
			theStatement.setInt(8, inShow.getFollowers());
			theStatement.setInt(9, inShow.getComments());
			theStatement.setInt(10, inShow.getSimilars());
			theStatement.setInt(11, inShow.getCharacters());
			theStatement.setInt(12, inShow.getLength());
			theStatement.setString(13, inShow.getNetwork());
			theStatement.setString(14, inShow.getRating());
			theStatement.setString(15, inShow.getStatus());
			theStatement.setString(16, inShow.getLanguage());
			theStatement.setInt(17, inShow.getNoteTotal());
			theStatement.setInt(18, inShow.getNoteMean());
			theStatement.setString(19, inShow.getBsUrl());
			theStatement.executeUpdate();
		} catch (SQLException e) {
			logger.error("Exception during the insertion of a show.");
			e.printStackTrace();
		}
		DbGenre theDbGenre = new DbGenre();
		ArrayList<Pair<Integer,String>> theShowGenreMapping = getShowGenreMappingByShowDb(inShow, theConn);
		List<Pair<Integer,String>> theGenresToDelete = new ArrayList<Pair<Integer,String>>();
		List<String> theGenresToSave = new ArrayList<String>();
		for (Pair<Integer,String> aMappingEntry: theShowGenreMapping){
			if(inShow.getGenres().contains(aMappingEntry.getValue1())){
				theGenresToSave.add(aMappingEntry.getValue1());
			}else{
				theGenresToDelete.add(aMappingEntry);
			}
		}
		Iterator<String> iteratorShow = inShow.getGenres().iterator();
		while (iteratorShow.hasNext()) {
			String inGenre = iteratorShow.next();
			if(!theGenresToSave.contains(inGenre)){
				theDbGenre.addGenre(inGenre);
				int idGenre = theDbGenre.selectIdByGenre(inGenre, theConn);
				addGenreShowMappingDb(idGenre, inShow, theConn);
			}
		}
		Iterator<Pair<Integer,String>> iteratorDeleteGenre = theGenresToDelete.iterator();
		while (iteratorDeleteGenre.hasNext()) {
			Pair<Integer, String> anEntry = iteratorDeleteGenre.next();
			deleteMAppingGenreShowDb(inShow, anEntry, theConn);
		}
	}
	
	protected void deleteMAppingGenreShowDb(Show inShow,
			Pair<Integer, String> anEntry, Connection aConn) {
		try {
			PreparedStatement theTruncateStatement = aConn.prepareStatement("DELETE from SHOW_GENRE_MAPPING where GENRE_ID = ? and SHOW_ID = ?;");
			theTruncateStatement.setInt(1, anEntry.getValue0());
			theTruncateStatement.setInt(2, (int) inShow.getId());
			theTruncateStatement.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void addGenreShowMappingDb(int inGenre, Show inShow,
			Connection theConn) {
		String sqlInsertGenreShowMapping = "Insert into SHOW_GENRE_MAPPING (SHOW_ID,GENRE_ID) values (?,?);";
		PreparedStatement theStatement;
		try {
			theStatement = theConn.prepareStatement(sqlInsertGenreShowMapping);
			theStatement.setInt(1, (int) inShow.getId());
			theStatement.setInt(2, inGenre);
		    theStatement.executeUpdate();
		} catch (SQLException e) {
			logger.error("Error during the insertion of an entry in GENRE_SHOW_MAPPING");
			e.printStackTrace();
		}
	}

	protected ArrayList<Pair<Integer, String>> getShowGenreMappingByShowDb(Show inShow, Connection theConn) {
		ArrayList<Pair<Integer,String>> theResult = new ArrayList<Pair<Integer,String>>();
		String theSelectQueryMappingJoin = "select ID_GENRE,GENRE.GENRE from GENRE,SHOW_GENRE_MAPPING"
				+ "where ID_SHOW = ? and ID_GENRE = GENRE.ID;";
		try {
			// create the java statement
			final PreparedStatement theStatement = theConn.prepareStatement(theSelectQueryMappingJoin);
			theStatement.setInt(1, (int) inShow.getId());
		    // execute the query, and get a java resultset
		    ResultSet theDbResults = theStatement.executeQuery();
		    while(theDbResults.next()){
		    	theResult.add(new Pair<Integer, String>((Integer)theDbResults.getObject(1), (String)theDbResults.getObject(2)));
		    }
		} catch (SQLException e) {
			logger.error("Exception during the select request for a SHOW GENRE mapping.");
			e.printStackTrace();
		}
		return theResult;
	}

	public void updateShow(Show inShow){
		updateShow(inShow, false, this.aDbSetup.connectToDB());
	}
	
	public void updateShow(Show inShow, boolean forceCreate){
		updateShow(inShow, forceCreate, this.aDbSetup.connectToDB());
	}
	
	public void updateShow(Show inShow, Connection theConn){
		updateShow(inShow, false, theConn);
	}

	
	public void updateShow(Show inShow, boolean forceCreate, Connection theConn){
		int theReturnId = -1;
		theReturnId = selectIdShow(inShow, theConn);
		if(theReturnId > -1){
			updateShowDb(inShow, theConn);
		}else if (forceCreate){
			insertShowDb(inShow, theConn);
		}
	}
	
	protected void updateShowDb(Show inShow, Connection theConn) {
		String sqlInsertGenre = "Update SHOW set THETVDBID = ?, IMDBID = ?, "
				+ "TITLE = ?, DESCRIPTION = ?, SEASONS = ?, EPISODES = ?, FOLLOWERS = ?, COMMENTS = ?, "
				+ "SIMILARS = ?, CHARACTERS = ?, LENGTH = ?, NETWORK = ?, RATING = ?, STATUS = ?, LANGUAGE = ?, "
				+ "NOTETOTAL = ?, NOTEMEAN = ?, URL = ? where ID = ?;";
		try {
			PreparedStatement theStatement = theConn.prepareStatement(sqlInsertGenre);
			theStatement.setInt(19, (int) inShow.getId());
			theStatement.setInt(1, (int) inShow.getTheTvDbId());
			theStatement.setInt(2, (int) inShow.getImdbId());
			theStatement.setString(3, inShow.getTitle());
			theStatement.setString(4, inShow.getDescription());
			theStatement.setInt(5, inShow.getSeasons());
			theStatement.setInt(6, inShow.getEpisodes());
			theStatement.setInt(7, inShow.getFollowers());
			theStatement.setInt(8, inShow.getComments());
			theStatement.setInt(9, inShow.getSimilars());
			theStatement.setInt(10, inShow.getCharacters());
			theStatement.setInt(11, inShow.getLength());
			theStatement.setString(12, inShow.getNetwork());
			theStatement.setString(13, inShow.getRating());
			theStatement.setString(14, inShow.getStatus());
			theStatement.setString(15, inShow.getLanguage());
			theStatement.setInt(16, inShow.getNoteTotal());
			theStatement.setInt(17, inShow.getNoteMean());
			theStatement.setString(18, inShow.getBsUrl());
			theStatement.executeUpdate();
		} catch (SQLException e) {
			logger.error("Exception during the update of a show.");
			e.printStackTrace();
		}
	}
	
	public int selectIdShow(Show inShow, Connection theConn) {
		int theReturnId = -1;
		String sqlSelectGenre = "Select ID from SHOW where SHOW.ID = ?;";
		try {
			// create the java statement
			final PreparedStatement theStatement = theConn.prepareStatement(sqlSelectGenre);
			theStatement.setInt(1, (int) inShow.getId());
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
