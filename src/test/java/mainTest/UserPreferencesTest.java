package mainTest;
import org.junit.Assert;
import org.junit.Test;

import utils.preferences.UserPreferences;


public class UserPreferencesTest {
	@Test
	public void connectTest(){
		System.out.println("->Testing 1 - Default Value of DB name");
		try {
			UserPreferences thePrefs = new UserPreferences();
			if(thePrefs.getSQLiteDBFile() != null){
				thePrefs.getUserPreferences().remove("SQLITE_DB_FILE");
			}
			Assert.assertNull(thePrefs.getSQLiteDBFile());
			thePrefs.setSQLiteDBFile();
			System.out.println(thePrefs.getSQLiteDBFile());
			Assert.assertEquals("JavaSeriesDBFile", thePrefs.getSQLiteDBFile());
			thePrefs.setSQLiteDBFile("JavaSeriesDBFile_TEST");
			System.out.println(thePrefs.getSQLiteDBFile());
			Assert.assertEquals("JavaSeriesDBFile_TEST", thePrefs.getSQLiteDBFile());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
