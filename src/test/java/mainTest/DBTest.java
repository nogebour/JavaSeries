package mainTest;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import DB.DbGenre;
import DB.DbSetUp;
import utils.LoggerUtils;
import utils.preferences.FilePreferencesFactory;
import utils.preferences.UserPreferences;

public class DBTest {
	
	private static final Logger logger = LoggerUtils.getLogger(DBTest.class);
	
	private Connection theConn;

	@Test
	public void connectTest(){
		logger.info("->Testing 1 - Default Value of DB name");
		try {
			UserPreferences thePrefs = new UserPreferences();
			thePrefs.setSQLiteDBFile();
			DbSetUp theDBClass = DbSetUp.getInstance();
			Assert.assertNotNull(theDBClass.connectToDB());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void initiateTest(){
		logger.info("->Testing 2 - Initiate DB");
		try {
			UserPreferences thePrefs = new UserPreferences();
			thePrefs.setSQLiteDBFile();
			DbSetUp theDBClass = DbSetUp.getInstance();;
			theConn = theDBClass.connectToDB();
			Assert.assertTrue(theDBClass.initiateDataBase(theConn));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void insertGenreTest(){
		logger.debug("->Testing 3 - Insert a genre");
		String aDummyGenre = "DUMMY";
		try {
			UserPreferences thePrefs = new UserPreferences();
			thePrefs.setSQLiteDBFile();
			DbSetUp theDBClass = DbSetUp.getInstance();;
			theConn = theDBClass.connectToDB();
			Assert.assertTrue(theDBClass.initiateDataBase(theConn));
			DbGenre theDbGenre = new DbGenre();
			theDbGenre.deleteGenreByGenre(aDummyGenre);
			int theReturnId = theDbGenre.addGenre(aDummyGenre);
			logger.debug("The id of DUMMY is "+theReturnId);
			Assert.assertTrue(theReturnId > -1);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
