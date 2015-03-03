package bom;

import java.util.Calendar;
import java.util.Date;
import java.util.Map.Entry;

import utils.Settings;

public class BSShowCenterLimited extends BSShowCenter {

	public void cleanListEpisodes(){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, Settings.LAST_LIMIT_USAGE);
		Date currentDateMinusDays = cal.getTime();
		System.out.println("Now "+Settings.LAST_LIMIT_USAGE+" days :"+currentDateMinusDays);
		for(Entry<Long, BSShow> entryShow : this.mappingShow.entrySet()){
			if(entryShow.getValue() instanceof BSShowLimited){
				BSShowLimited aLimShow = (BSShowLimited) entryShow.getValue();
				aLimShow.setAccessMode(false);
				if(aLimShow.getLastUsage().before(currentDateMinusDays)){
					break;
				}
				for(Entry<Long, BSEpisodes> entryEpisode : aLimShow.getEpisodesList().entrySet()){
					if(entryEpisode.getValue() instanceof BSEpisodesLimited){
						BSEpisodesLimited aLimEp = (BSEpisodesLimited) entryEpisode.getValue();
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
