package bom;

import java.util.List;
public class BSSeries {

	private String title;
	private int id;
	private int thetvdb_id;
	private int imdb_id;
	private String description;
	private int seasons;
	//private List<BSSeason> seasonList;
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
	
	public BSSeries() {
			super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getThetvdb_id() {
		return thetvdb_id;
	}

	public void setThetvdb_id(int thetvdb_id) {
		this.thetvdb_id = thetvdb_id;
	}

	public int getImdb_id() {
		return imdb_id;
	}

	public void setImdb_id(int imdb_id) {
		this.imdb_id = imdb_id;
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
	
	
}
