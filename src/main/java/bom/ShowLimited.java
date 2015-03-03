package bom;

import interfaces.IntLimitedLifeTimeBom;

import java.nio.MappedByteBuffer;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import utils.Settings;

public class ShowLimited extends Show implements IntLimitedLifeTimeBom {
	private Date lastUsage;
	private boolean accessMode;
	
	public ShowLimited() {
		super();
		this.updateDate();
	}
	
	public boolean isAccessMode() {
		return accessMode;
	}

	public void setAccessMode(boolean accessMode) {
		this.accessMode = accessMode;
	}

	private void updateDate() {
		if(accessMode){
			lastUsage = new Date();
		}
	}
	
	public Date getLastUsage() {
		return lastUsage;
	}
	/* (non-Javadoc)
	 * @see bom.BSShow#addEpisode(bom.BSEpisodes)
	 */
	@Override
	public boolean addEpisode(Episode episode) {
		this.updateDate();
		return super.addEpisode(episode);
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#getTitle()
	 */
	@Override
	public String getTitle() {
		this.updateDate();
		return super.getTitle();
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#setTitle(java.lang.String)
	 */
	@Override
	public void setTitle(String title) {
		this.updateDate();
		super.setTitle(title);
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#getId()
	 */
	@Override
	public long getId() {
		this.updateDate();
		return super.getId();
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#setId(long)
	 */
	@Override
	public void setId(long l) {
		this.updateDate();
		super.setId(l);
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#getThetvdb_id()
	 */
	@Override
	public long getTheTvDbId() {
		this.updateDate();
		return super.getTheTvDbId();
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#setThetvdb_id(int)
	 */
	@Override
	public void setTheTvDbId(long thetvdb_id) {
		this.updateDate();
		super.setTheTvDbId(thetvdb_id);
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#getImdb_id()
	 */
	@Override
	public long getImdbId() {
		this.updateDate();
		return super.getImdbId();
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#setImdb_id(long)
	 */
	@Override
	public void setImdbId(long l) {
		this.updateDate();
		super.setImdbId(l);
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#getDescription()
	 */
	@Override
	public String getDescription() {
		this.updateDate();
		return super.getDescription();
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#setDescription(java.lang.String)
	 */
	@Override
	public void setDescription(String description) {
		this.updateDate();
		super.setDescription(description);
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#getSeasons()
	 */
	@Override
	public int getSeasons() {
		this.updateDate();
		return super.getSeasons();
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#setSeasons(int)
	 */
	@Override
	public void setSeasons(int seasons) {
		this.updateDate();
		super.setSeasons(seasons);
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#getEpisodesList()
	 */
	@Override
	public Map<Long, Episode> getEpisodesList() {
		this.updateDate();
		return super.getEpisodesList();
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#setEpisodesList(java.util.Map)
	 */
	@Override
	public void setEpisodesList(Map<Long, Episode> seasonList) {
		this.updateDate();
		super.setEpisodesList(seasonList);
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#getEpisodes()
	 */
	@Override
	public int getEpisodes() {
		this.updateDate();
		return super.getEpisodes();
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#setEpisodes(int)
	 */
	@Override
	public void setEpisodes(int episodes) {
		this.updateDate();
		super.setEpisodes(episodes);
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#getFollowers()
	 */
	@Override
	public int getFollowers() {
		this.updateDate();
		return super.getFollowers();
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#setFollowers(int)
	 */
	@Override
	public void setFollowers(int followers) {
		this.updateDate();
		super.setFollowers(followers);
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#getComments()
	 */
	@Override
	public int getComments() {
		this.updateDate();
		return super.getComments();
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#setComments(int)
	 */
	@Override
	public void setComments(int comments) {
		this.updateDate();
		super.setComments(comments);
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#getSimilars()
	 */
	@Override
	public int getSimilars() {
		this.updateDate();
		return super.getSimilars();
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#setSimilars(int)
	 */
	@Override
	public void setSimilars(int similars) {
		this.updateDate();
		super.setSimilars(similars);
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#getCharacters()
	 */
	@Override
	public int getCharacters() {
		this.updateDate();
		return super.getCharacters();
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#setCharacters(int)
	 */
	@Override
	public void setCharacters(int characters) {
		this.updateDate();
		super.setCharacters(characters);
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#getGenres()
	 */
	@Override
	public List<String> getGenres() {
		this.updateDate();
		return super.getGenres();
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#setGenres(java.util.List)
	 */
	@Override
	public void setGenres(List<String> genres) {
		this.updateDate();
		super.setGenres(genres);
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#getLenght()
	 */
	@Override
	public int getLength() {
		this.updateDate();
		return super.getLength();
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#setLenght(int)
	 */
	@Override
	public void setLength(int lenght) {
		this.updateDate();
		super.setLength(lenght);
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#getNetwork()
	 */
	@Override
	public String getNetwork() {
		this.updateDate();
		return super.getNetwork();
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#setNetwork(java.lang.String)
	 */
	@Override
	public void setNetwork(String network) {
		this.updateDate();
		super.setNetwork(network);
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#getRating()
	 */
	@Override
	public String getRating() {
		this.updateDate();
		return super.getRating();
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#setRating(java.lang.String)
	 */
	@Override
	public void setRating(String rating) {
		this.updateDate();
		super.setRating(rating);
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#getStatus()
	 */
	@Override
	public String getStatus() {
		this.updateDate();
		return super.getStatus();
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#setStatus(java.lang.String)
	 */
	@Override
	public void setStatus(String status) {
		this.updateDate();
		super.setStatus(status);
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#getLanguage()
	 */
	@Override
	public String getLanguage() {
		this.updateDate();
		return super.getLanguage();
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#setLanguage(java.lang.String)
	 */
	@Override
	public void setLanguage(String language) {
		this.updateDate();
		super.setLanguage(language);
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#getNoteTotal()
	 */
	@Override
	public int getNoteTotal() {
		this.updateDate();
		return super.getNoteTotal();
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#setNoteTotal(int)
	 */
	@Override
	public void setNoteTotal(int noteTotal) {
		this.updateDate();
		super.setNoteTotal(noteTotal);
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#getNoteMean()
	 */
	@Override
	public int getNoteMean() {
		this.updateDate();
		return super.getNoteMean();
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#setNoteMean(int)
	 */
	@Override
	public void setNoteMean(int noteMean) {
		this.updateDate();
		super.setNoteMean(noteMean);
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#getBsUrl()
	 */
	@Override
	public String getBsUrl() {
		this.updateDate();
		return super.getBsUrl();
	}

	/* (non-Javadoc)
	 * @see bom.BSShow#setBsUrl(java.lang.String)
	 */
	@Override
	public void setBsUrl(String bsUrl) {
		this.updateDate();
		super.setBsUrl(bsUrl);
	}

}
