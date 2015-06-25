package utils.preferences;

import java.util.prefs.Preferences;

public class UserPreferences {
	private static final String SQLITE_DB_FILE = "SQLITE_DB_FILE";
	// declare my variable at the top of my Java class
	private static Preferences PREFS = null;
	
	public UserPreferences(){
		if(PREFS == null){
	    System.setProperty("java.util.prefs.PreferencesFactory", FilePreferencesFactory.class.getName());
	    System.setProperty(FilePreferencesFactory.SYSTEM_PROPERTY_FILE, "preferences.javaseries");
	    PREFS = Preferences.userNodeForPackage(UserPreferences.class);
		}
	}
	
	public Preferences getUserPreferences(){
		return PREFS;
	}
	
	public Object getValue(String key){
		return PREFS.get(key, null);
	}
	
	public String getSQLiteDBFile(){
		return PREFS.get(SQLITE_DB_FILE, null);
	}
	
	public void setSQLiteDBFile(String fileName){
		PREFS.put(SQLITE_DB_FILE, fileName);
	}
	public void setSQLiteDBFile(){
		setSQLiteDBFile("JavaSeriesDBFile");
	}
}
