package utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import utils.preferences.UserPreferences;
import DB.DbSetUp;

public class LoggerUtils {
	
	private static String PATH = null; 
	
	public static Logger getLogger(Class<?> aClass){
		Logger logger = Logger.getLogger(aClass);
		if (PATH == null){
			//UserPreferences thePrefs = new UserPreferences();
			//PATH = thePrefs.getLog4jFile();
			PATH = "log4j.properties";
		}
		PropertyConfigurator.configure(PATH);
	    return logger;
	}
	
}
