package bom;

import interfaces.IntBomObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
public class BSShow implements IntBomObject{

	private String title;
	private long id;
	private long thetvdb_id;
	private long imdb_id;
	private String description;
	private int seasons;
	//private List<BSSeason> seasonList;
	private Map<Long,BSEpisodes> episodesList;
	private int episodes;
	private int followers;
	private int comments;
	private int similars;
	private int characters;
	private List<String> genres;
	private int lenght;
	private String network;
	private String rating;
	private String status;
	private String language;
	private int noteTotal;
	private int noteMean;
	private String bsUrl;
	
	public BSShow() {
			super();
			this.episodesList = new HashMap<Long, BSEpisodes>();
	}

	public boolean addEpisode(BSEpisodes episode){
		if(episode.getIdShow()==this.id){
			if (this.episodesList.containsKey(episode.getGlobalNumber())){
				return true;
			}else{
				this.episodesList.put(episode.getGlobalNumber(), episode);
			}
		}else{
			return false;
		}
		return true;
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

	public long getThetvdb_id() {
		return thetvdb_id;
	}

	public void setThetvdb_id(int thetvdb_id) {
		this.thetvdb_id = thetvdb_id;
	}

	public long getImdb_id() {
		return imdb_id;
	}

	public void setImdb_id(long l) {
		this.imdb_id = l;
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

	public Map<Long,BSEpisodes> getEpisodesList() {
		return episodesList;
	}

	public void setEpisodesList(Map<Long,BSEpisodes> seasonList) {
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

	public int getLenght() {
		return lenght;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
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
		if(thetvdb_id != 0){
			result += "thetvdb_id/"+thetvdb_id+" ";
		}
		if(imdb_id != 0){
			result += "imdb_id/"+imdb_id+" ";
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
		if(lenght != 0){
			result += "lenght/"+lenght+" ";
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
