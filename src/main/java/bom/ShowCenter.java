package bom;

import interfaces.IntBomObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ShowCenter implements IntBomObject{
	protected Map<Long, Show> mappingShow;
	
	public ShowCenter(){
		mappingShow = new HashMap<Long, Show>();
	}

	public Map<Long, Show> getMappingShow() {
		return mappingShow;
	}

	private void setMappingShow(Map<Long, Show> mappingShow) {
		this.mappingShow = mappingShow;
	}
	
	public Show getShowById(long idShow){
		return this.mappingShow.get(idShow);
	}
	
	public boolean addShow(Show show){
		if (!this.mappingShow.containsKey(show.getId())){
			this.mappingShow.put(show.getId(), show);
			return true;
		}else{
			this.mappingShow.get(show.getId()).updateShow(show);
			return false;	
		}
	}

	public String dump() {
		String result = "There are "+this.mappingShow.size()+" shows in the BSShowCenter:";
		for (Map.Entry<Long, Show> entry : mappingShow.entrySet()){
			result+="\n\t-> "+entry.getValue().getTitle()+" with these informations:"+entry.getValue().shortDump();
			for(Entry<Long, Episode> entryEpisode : entry.getValue().getEpisodesList().entrySet()){
				result += "\n\t\t->"+entryEpisode.getValue().dump();
			}
		}
		return result;
	}
}
