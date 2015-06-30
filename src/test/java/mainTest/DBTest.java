package mainTest;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Test;

import DB.DbSetUp;
import utils.preferences.UserPreferences;

public class DBTest {
	private Connection theConn;

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
	
	@Test
	public void initiateTest(){
		System.out.println("->Testing 2 - Initiate DB");
		try {
			UserPreferences thePrefs = new UserPreferences();
			thePrefs.setSQLiteDBFile();
			DbSetUp theDBClass = new DbSetUp();
			theConn = theDBClass.connectToDB();
			Assert.assertTrue(theDBClass.initiateDataBase(theConn));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
