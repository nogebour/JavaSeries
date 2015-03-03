package factory;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import utils.Settings;
import bom.BSEpisodes;

/**
 * Factory which allow to create and store the BSEpisode.
 * @author Noel_Nicolas
 * 
 * The idea is not to recreate the garbage collector but to keep a trace of the usage of each BSEpisodes
 * to avoid too much usage of hard drive space. If the objects are not used for a while, you delete it.
 * It means that you must retrieve each objects which use it. We keep local copy of information in case
 * the user is offline so we can try to avoid to make request if we have information. In another hand, too
 * much information could lead to an increase space disk usage and slower application. The idea is to make
 * for new episodes or for old episodes. The current episodes (from planning, etc .) are already in the database
 */

public class FacEpisodes {
	public Map<BSEpisodes, Date> listofAllEpisodes;
	public final static FacEpisodes INSTANCE = new FacEpisodes();
	
	public FacEpisodes(){
		listofAllEpisodes = new HashMap<BSEpisodes, Date>();
	}
	
	public BSEpisodes getNewEpisode(){
		BSEpisodes episode = new BSEpisodes();
		listofAllEpisodes.put(episode, new Date());
		return episode;
	}
	
	/**
	 * TODO: Move method to BSShowCenterLimited
	 */
	public void cleanListEpisodes(){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, Settings.LAST_LIMIT_USAGE);
		Date currentDateMinusDays = cal.getTime();
		System.out.println("Now "+Settings.LAST_LIMIT_USAGE+" days :"+currentDateMinusDays);		
		for(Entry<BSEpisodes, Date> entryEpisode : listofAllEpisodes.entrySet()){
			if(entryEpisode.getValue().before(currentDateMinusDays)){				
			}
		}
	}
	
}
