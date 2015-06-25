package mainTest;

import org.junit.Assert;
import org.junit.Test;

import DB.DbSetUp;
import utils.preferences.UserPreferences;

public class DBTest {
	@Test
	public void connectTest(){
		System.out.println("->Testing 1 - Default Value of DB name");
		try {
			UserPreferences thePrefs = new UserPreferences();
			thePrefs.setSQLiteDBFile();
			DbSetUp theDBClass = new DbSetUp();
			Assert.assertNotNull(theDBClass.connectToDB());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
