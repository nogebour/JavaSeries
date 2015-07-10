package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbGenre {
	
	private DbSetUp aDbSetup;
	
	public DbGenre(){
		aDbSetup = DbSetUp.getInstance();
	}
	
	public DbGenre(DbSetUp inDbSetup){
		this.aDbSetup = inDbSetup;
	}
	
	public int addGenre(String genre){
		return addGenre(genre, aDbSetup.connectToDB());
	}
	
	public int addGenre(String genre, Connection theConn) {
		int theReturnId = -1;
		theReturnId = selectIdByGenre(genre, theConn);
		if(theReturnId == -1){
			insertGenre(genre, theConn);
			theReturnId = selectIdByGenre(genre, theConn);
		}
		return theReturnId;
	}

	protected void insertGenre(String genre, Connection theConn) {
		String sqlInsertGenre = "Insert into GENRE (GENRE) values (?);";
		PreparedStatement theStatement;
		try {
			theStatement = theConn.prepareStatement(sqlInsertGenre);
			theStatement.setString(1, genre);
			theStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected int selectIdByGenre(String genre, Connection theConn) {
		int theReturnId = -1;
		String sqlSelectGenre = "Select ID from GENRE where GENRE.GENRE = ?;";
		try {
			// create the java statement
			final PreparedStatement theStatement = theConn.prepareStatement(sqlSelectGenre);
			theStatement.setString(1, genre);
		    // execute the query, and get a java resultset
		    ResultSet theResults = theStatement.executeQuery();
		    if(theResults.next()){
		    	theReturnId = theResults.getInt("ID");
		    }
		} catch (SQLException e) {
			e.printStackTrace();
			return theReturnId;
		}
		return theReturnId;
	}

	public int deleteGenreByGenre(String aGenre) {
		return this.deleteGenreByGenre(aGenre, aDbSetup.connectToDB());
	}

	protected int deleteGenreByGenre(String aGenre, Connection aConn) {
		PreparedStatement theTruncateStatement;
		int returnCode = 0;
		try {
			theTruncateStatement = aConn.prepareStatement("DELETE from GENRE where GENRE.GENRE = ?;");
			theTruncateStatement.setString(1, aGenre);
			theTruncateStatement.executeUpdate();	
		} catch (SQLException e) {
			returnCode = 2;
			e.printStackTrace();
		}
		return returnCode;
	}	
}
