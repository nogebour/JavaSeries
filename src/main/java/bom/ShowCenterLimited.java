package bom;

import java.util.Calendar;
import java.util.Date;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import utils.LoggerUtils;
import utils.Settings;

public class ShowCenterLimited extends ShowCenter {

	final static Logger logger = LoggerUtils.getLogger(ShowCenterLimited.class);
	
	public void cleanListEpisodes(){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, Settings.LAST_LIMIT_USAGE);
		Date currentDateMinusDays = cal.getTime();
		logger.debug("Now "+Settings.LAST_LIMIT_USAGE+" days :"+currentDateMinusDays);
		for(Entry<Long, Show> entryShow : this.mappingShow.entrySet()){
			if(entryShow.getValue() instanceof ShowLimited){
				ShowLimited aLimShow = (ShowLimited) entryShow.getValue();
				aLimShow.setAccessMode(false);
				if(aLimShow.getLastUsage().before(currentDateMinusDays)){
					break;
				}
				for(Entry<Long, Episode> entryEpisode : aLimShow.getEpisodesList().entrySet()){
					if(entryEpisode.getValue() instanceof EpisodeLimited){
						EpisodeLimited aLimEp = (EpisodeLimited) entryEpisode.getValue();
						aLimEp.setAccessMode(false);
						if(aLimEp.getLastUsage().before(currentDateMinusDays)){
							break;
						}
						aLimEp.setAccessMode(true);
					}
				}
				aLimShow.setAccessMode(true);
			}
		}
	}

}
