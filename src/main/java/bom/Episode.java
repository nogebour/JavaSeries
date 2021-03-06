package bom;

import interfaces.IntBomObject;

public class Episode implements IntBomObject{
	private long id;
	private long theTvDbId;
	private String title;
	private long season;
	private long episode;
	private long idShow;
	private String code;
	private long globalNumber;
	private String description;
	private String date;
	
	public Episode() {
	}

	public boolean updateShow(Episode aShow){
		boolean hasbeenUpdated = false;
		if(aShow.getId() != 0 && id != aShow.getId()){
			this.setId(aShow.getId());
			hasbeenUpdated = true;
		}
		if(aShow.getTheTvDbId() != 0 && theTvDbId != aShow.getTheTvDbId()){
			this.setTheTvDbId(aShow.getTheTvDbId());
			hasbeenUpdated = true;
		}
		if(aShow.getTitle() != null && title != aShow.getTitle()){
			this.setTitle(aShow.getTitle());
			hasbeenUpdated = true;
		}
		if(aShow.getSeason() != 0 && season != aShow.getSeason()){
			this.setSeason(aShow.getSeason());
			hasbeenUpdated = true;
		}
		if(aShow.getEpisode() != 0 && episode != aShow.getEpisode()){
			this.setEpisode(aShow.getEpisode());
			hasbeenUpdated = true;
		}
		if(aShow.getIdShow() != 0 && idShow != aShow.getIdShow()){
			this.setIdShow(aShow.getIdShow());
			hasbeenUpdated = true;
		}
		if(aShow.getCode() != null && code != aShow.getCode()){
			this.setCode(aShow.getCode());
			hasbeenUpdated = true;
		}
		if(aShow.getGlobalNumber() != 0 && globalNumber != aShow.getGlobalNumber()){
			this.setGlobalNumber(aShow.getGlobalNumber());
			hasbeenUpdated = true;
		}
		if(aShow.getDescription() != null && description != aShow.getDescription()){
			this.setDescription(aShow.getDescription());
			hasbeenUpdated = true;
		}
		if(aShow.getDate() != null && date != aShow.getDate()){
			this.setDate(aShow.getDate());
			hasbeenUpdated = true;
		}
		return hasbeenUpdated;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTheTvDbId() {
		return theTvDbId;
	}

	public void setTheTvDbId(long theTvDbId) {
		this.theTvDbId = theTvDbId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getSeason() {
		return season;
	}

	public void setSeason(long season) {
		this.season = season;
	}

	public long getEpisode() {
		return episode;
	}

	public void setEpisode(long episode) {
		this.episode = episode;
	}

	public long getIdShow() {
		return idShow;
	}

	public void setIdShow(long idShow) {
		this.idShow = idShow;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public long getGlobalNumber() {
		return globalNumber;
	}

	public void setGlobalNumber(long globalNumber) {
		this.globalNumber = globalNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String dump() {
		String result = "";
		if(globalNumber != 0){
			result += "globalNumber/"+globalNumber+" ";
		}
		if(code != null){
			result += "code/\""+code+"\" ";
		}
		if(title != null){
			result += "title/\""+title+"\" ";
		}
		if(id != 0){
			result += "id/"+id+" ";
		}
		if(theTvDbId != 0){
			result += "theTvDbId/"+theTvDbId+" ";
		}
		if(season != 0){
			result += "season/"+season+" ";
		}
		if(episode != 0){
			result += "episode/"+episode+" ";
		}
		if(idShow != 0){
			result += "idShow/"+idShow+" ";
		}
		if(date != null){
			result += "date/\""+date+"\" ";
		}
		if(description != null){
			result += "description/\""+description+"\" ";
		}
		return result;
	}

}
