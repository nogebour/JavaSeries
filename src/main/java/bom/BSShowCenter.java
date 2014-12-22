package bom;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BSShowCenter {
	public static BSShowCenter INSTANCE = new BSShowCenter();
	private Map<Long, BSShow> mappingShow;
	
	public BSShowCenter(){
		mappingShow = new HashMap<Long, BSShow>();
	}

	public Map<Long, BSShow> getMappingShow() {
		return mappingShow;
	}

	private void setMappingShow(Map<Long, BSShow> mappingShow) {
		this.mappingShow = mappingShow;
	}
	
	public BSShow getShowById(long idShow){
		return this.mappingShow.get(idShow);
	}
	
	public boolean addShow(BSShow show){
		if (!this.mappingShow.containsKey(show.getId())){
			this.mappingShow.put(show.getId(), show);
			return true;
		}
		return false;
	}

	public String dump() {
		String result = "There are "+this.mappingShow.size()+" shows in the BSShowCenter:";
		for (Map.Entry<Long, BSShow> entry : mappingShow.entrySet()){
			result+="\n\t-> id: "+entry.getKey()+" corresponds to \""+entry.getValue().getTitle()+"\" with this values: Imbd_id/"+entry.getValue().getImdb_id();
		}
		return result;
	}
}