package mainTest;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import utils.LoggerUtils;
import utils.preferences.UserPreferences;


public class UserPreferencesTest {
	private static final Logger logger = LoggerUtils.getLogger(UserPreferencesTest.class);
	
	@Test
	public void connectTest(){
		logger.info("->Testing 1 - Default Value of DB name");
		try {
			UserPreferences thePrefs = new UserPreferences();
			if(thePrefs.getSQLiteDBFile() != null){
				thePrefs.getUserPreferences().remove("SQLITE_DB_FILE");
			}
			Assert.assertNull(thePrefs.getSQLiteDBFile());
			thePrefs.setSQLiteDBFile();
			logger.debug(thePrefs.getSQLiteDBFile());
			Assert.assertEquals("JavaSeriesDBFile", thePrefs.getSQLiteDBFile());
			thePrefs.setSQLiteDBFile("JavaSeriesDBFile_TEST");
			logger.debug(thePrefs.getSQLiteDBFile());
			Assert.assertEquals("JavaSeriesDBFile_TEST", thePrefs.getSQLiteDBFile());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
