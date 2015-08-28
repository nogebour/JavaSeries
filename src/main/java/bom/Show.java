package bom;

import interfaces.IntBomObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Show implements IntBomObject{

	private String title;
	private long id;
	private long theTvDbId;
	private long imdbId;
	private String description;
	private int seasons;
	private Map<Long,Episode> episodesList;
	private int episodes;
	private int followers;
	private int comments;
	private int similars;
	private int characters;
	private List<String> genres;
	private int length;
	private String network;
	private String rating;
	private String status;
	private String language;
	private int noteTotal;
	private int noteMean;
	private String bsUrl;

	public Show() {
		super();
		this.episodesList = new HashMap<Long, Episode>();
		this.genres = new ArrayList<String>();
	}

	public boolean addEpisode(Episode episode){
		return this.addOrUpdateEpisode(episode, true);
	}
	
	public boolean updateEpisode(Episode episode){
		return this.addOrUpdateEpisode(episode, false);
	}
	
	public boolean addOrUpdateEpisode(Episode episode, boolean addOnly){
		if(episode.getIdShow()==this.id){
			if (this.episodesList.containsKey(episode.getGlobalNumber())){
				if(addOnly){
					return false;
				}else{
					this.episodesList.get(episode.getGlobalNumber()).updateShow(episode);
				}
			}else{
				this.episodesList.put(episode.getGlobalNumber(), episode);
			}
		}else{
			return false;
		}
		return true;
	}

	public boolean updateShow(Show aShow){
		boolean hasbeenUpdated = false;
		if(aShow.getTitle() != null && title != aShow.getTitle()){
			this.setTitle(aShow.getTitle());
			hasbeenUpdated = true;
		}
		if(aShow.getId() != 0 && id != aShow.getId()){
			this.setId(aShow.getId());
			hasbeenUpdated = true;
		}
		if(aShow.getTheTvDbId() != 0 && theTvDbId != aShow.getTheTvDbId()){
			this.setTheTvDbId(aShow.getTheTvDbId());
			hasbeenUpdated = true;
		}
		if(aShow.getImdbId() != 0 && imdbId != aShow.getImdbId()){
			this.setImdbId(aShow.getImdbId());
			hasbeenUpdated = true;
		}
		if(aShow.getDescription() != null && description != aShow.getDescription()){
			this.setDescription(aShow.getDescription());
			hasbeenUpdated = true;
		}
		if(aShow.getSeasons() != 0 && seasons != aShow.getSeasons()){
			this.setSeasons(aShow.getSeasons());
			hasbeenUpdated = true;
		}
		if(aShow.getEpisodesList() != null){
			for(Map.Entry<Long, Episode> entry : aShow.getEpisodesList().entrySet()){
				this.updateEpisode(entry.getValue());
				hasbeenUpdated = true;
			}
		}
		if(aShow.getEpisodes() != 0 && episodes != aShow.getEpisodes()){
			this.setEpisodes(aShow.getEpisodes());
			hasbeenUpdated = true;
		}
		if(aShow.getFollowers() != 0 && followers != aShow.getFollowers()){
			this.setFollowers(aShow.getFollowers());
			hasbeenUpdated = true;
		}
		if(aShow.getComments() != 0 && comments != aShow.getComments()){
			this.setComments(aShow.getComments());
			hasbeenUpdated = true;
		}
		if(aShow.getSimilars() != 0 && similars != aShow.getSimilars()){
			this.setSimilars(aShow.getSimilars());
			hasbeenUpdated = true;
		}
		if(aShow.getCharacters() != 0 && characters != aShow.getCharacters()){
			this.setCharacters(aShow.getCharacters());
			hasbeenUpdated = true;
		}
		if(aShow.getGenres() != null){
			this.setGenres(aShow.getGenres());
			hasbeenUpdated = true;
		}
		if(aShow.getLength() != 0 && length != aShow.getLength()){
			this.setLength(aShow.getLength());
			hasbeenUpdated = true;
		}
		if(aShow.getNetwork() != null && network != aShow.getNetwork()){
			this.setNetwork(aShow.getNetwork());
			hasbeenUpdated = true;
		}
		if(aShow.getRating() != null && rating != aShow.getRating()){
			this.setRating(aShow.getRating());
			hasbeenUpdated = true;
		}
		if(aShow.getStatus() != null && status != aShow.getStatus()){
			this.setStatus(aShow.getStatus());
			hasbeenUpdated = true;
		}
		if(aShow.getLanguage() != null && language != aShow.getLanguage()){
			this.setLanguage(aShow.getLanguage());
			hasbeenUpdated = true;
		}
		if(aShow.getNoteTotal() != 0 && noteTotal != aShow.getNoteTotal()){
			this.setNoteTotal(aShow.getNoteTotal());
			hasbeenUpdated = true;
		}
		if(aShow.getNoteMean() != 0 && noteMean != aShow.getNoteMean()){
			this.setNoteMean(aShow.getNoteMean());
			hasbeenUpdated = true;
		}
		if(aShow.getBsUrl() != null && bsUrl != aShow.getBsUrl()){
			this.setBsUrl(aShow.getBsUrl());
			hasbeenUpdated = true;
		}
		return hasbeenUpdated;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getId() {
		return id;
	}

	public void setId(long l) {
		this.id = l;
	}

	public long getTheTvDbId() {
		return theTvDbId;
	}

	public void setTheTvDbId(long thetvdb_id) {
		this.theTvDbId = thetvdb_id;
	}

	public long getImdbId() {
		return imdbId;
	}

	public void setImdbId(long l) {
		this.imdbId = l;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSeasons() {
		return seasons;
	}

	public void setSeasons(int seasons) {
		this.seasons = seasons;
	}

	public Map<Long,Episode> getEpisodesList() {
		return episodesList;
	}

	public void setEpisodesList(Map<Long,Episode> seasonList) {
		this.episodesList = seasonList;
	}

	public int getEpisodes() {
		return episodes;
	}

	public void setEpisodes(int episodes) {
		this.episodes = episodes;
	}

	public int getFollowers() {
		return followers;
	}

	public void setFollowers(int followers) {
		this.followers = followers;
	}

	public int getComments() {
		return comments;
	}

	public void setComments(int comments) {
		this.comments = comments;
	}

	public int getSimilars() {
		return similars;
	}

	public void setSimilars(int similars) {
		this.similars = similars;
	}

	public int getCharacters() {
		return characters;
	}

	public void setCharacters(int characters) {
		this.characters = characters;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int lenght) {
		this.length = lenght;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getNoteTotal() {
		return noteTotal;
	}

	public void setNoteTotal(int noteTotal) {
		this.noteTotal = noteTotal;
	}

	public int getNoteMean() {
		return noteMean;
	}

	public void setNoteMean(int noteMean) {
		this.noteMean = noteMean;
	}

	public String getBsUrl() {
		return bsUrl;
	}

	public void setBsUrl(String bsUrl) {
		this.bsUrl = bsUrl;
	}

	public String shortDump() {
		String result = "";
		if(title != null){
			result += "title/\""+title+"\" ";
		}
		if(id != 0){
			result += "id/"+id+" ";
		}
		if(theTvDbId != 0){
			result += "thetvdb_id/"+theTvDbId+" ";
		}
		if(imdbId != 0){
			result += "imdb_id/"+imdbId+" ";
		}
		if(description != null){
			result += "description/\""+description+"\" ";
		}
		if(seasons != 0){
			result += "seasons/"+seasons+" ";
		}
		if(episodes != 0){
			result += "episodes/"+episodes+" ";
		}
		if(followers != 0){
			result += "followers/"+followers+" ";
		}
		if(comments != 0){
			result += "comments/"+comments+" ";
		}
		if(similars != 0){
			result += "similars/"+similars+" ";
		}
		if(characters != 0){
			result += "characters/"+characters+" ";
		}
		if(genres != null && genres.size() > 0){
			result += "episodes/";
			for(int itGenre = 0; itGenre < genres.size()-1; itGenre++){
				result += "\""+genres.get(itGenre)+"\",";
			}
			result += "\""+genres.get(genres.size()-1)+"\"";
		}
		if(length != 0){
			result += "length/"+length+" ";
		}
		if(network != null){
			result += "network/\""+network+"\" ";
		}
		if(rating != null){
			result += "rating/"+rating+" ";
		}
		if(status != null){
			result += "status/\""+status+"\" ";
		}
		if(language != null){
			result += "language/\""+language+"\" ";
		}
		if(noteTotal != 0){
			result += "noteTotal/"+noteTotal+" ";
		}
		if(noteMean != 0){
			result += "noteMean/"+noteMean+" ";
		}
		if(bsUrl != null){
			result += "bsUrl/\""+bsUrl+"\" ";
		}
		return result;
	}


}
