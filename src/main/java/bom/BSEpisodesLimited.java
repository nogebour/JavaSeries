package bom;

import interfaces.IntLimitedLifeTimeBom;

import java.util.Date;

public class BSEpisodesLimited extends BSEpisodes implements IntLimitedLifeTimeBom{
	private Date last_usage;
	
	public BSEpisodesLimited() {
		this.updateDate();
	}

	private void updateDate() {
		last_usage = new Date();
	}

	
	/* (non-Javadoc)
	 * @see bom.BSEpisodes#getId()
	 */
	@Override
	public long getId() {
		this.updateDate();
		return super.getId();
	}

	/* (non-Javadoc)
	 * @see bom.BSEpisodes#setId(long)
	 */
	@Override
	public void setId(long id) {
		this.updateDate();
		super.setId(id);
	}

	/* (non-Javadoc)
	 * @see bom.BSEpisodes#getTheTvDbId()
	 */
	@Override
	public long getTheTvDbId() {
		this.updateDate();
		return super.getTheTvDbId();
	}

	/* (non-Javadoc)
	 * @see bom.BSEpisodes#setTheTvDbId(long)
	 */
	@Override
	public void setTheTvDbId(long theTvDbId) {
		this.updateDate();
		super.setTheTvDbId(theTvDbId);
	}

	/* (non-Javadoc)
	 * @see bom.BSEpisodes#getTitle()
	 */
	@Override
	public String getTitle() {
		this.updateDate();
		return super.getTitle();
	}

	/* (non-Javadoc)
	 * @see bom.BSEpisodes#setTitle(java.lang.String)
	 */
	@Override
	public void setTitle(String title) {
		this.updateDate();
		super.setTitle(title);
	}

	/* (non-Javadoc)
	 * @see bom.BSEpisodes#getSeason()
	 */
	@Override
	public long getSeason() {
		this.updateDate();
		return super.getSeason();
	}

	/* (non-Javadoc)
	 * @see bom.BSEpisodes#setSeason(long)
	 */
	@Override
	public void setSeason(long season) {
		this.updateDate();
		super.setSeason(season);
	}

	/* (non-Javadoc)
	 * @see bom.BSEpisodes#getEpisode()
	 */
	@Override
	public long getEpisode() {
		this.updateDate();
		return super.getEpisode();
	}

	/* (non-Javadoc)
	 * @see bom.BSEpisodes#setEpisode(long)
	 */
	@Override
	public void setEpisode(long episode) {
		this.updateDate();
		super.setEpisode(episode);
	}

	/* (non-Javadoc)
	 * @see bom.BSEpisodes#getIdShow()
	 */
	@Override
	public long getIdShow() {
		this.updateDate();
		return super.getIdShow();
	}

	/* (non-Javadoc)
	 * @see bom.BSEpisodes#setIdShow(long)
	 */
	@Override
	public void setIdShow(long idShow) {
		this.updateDate();
		super.setIdShow(idShow);
	}

	/* (non-Javadoc)
	 * @see bom.BSEpisodes#getCode()
	 */
	@Override
	public String getCode() {
		this.updateDate();
		return super.getCode();
	}

	/* (non-Javadoc)
	 * @see bom.BSEpisodes#setCode(java.lang.String)
	 */
	@Override
	public void setCode(String code) {
		this.updateDate();
		super.setCode(code);
	}

	/* (non-Javadoc)
	 * @see bom.BSEpisodes#getGlobalNumber()
	 */
	@Override
	public long getGlobalNumber() {
		this.updateDate();
		return super.getGlobalNumber();
	}

	/* (non-Javadoc)
	 * @see bom.BSEpisodes#setGlobalNumber(long)
	 */
	@Override
	public void setGlobalNumber(long globalNumber) {
		this.updateDate();
		super.setGlobalNumber(globalNumber);
	}

	/* (non-Javadoc)
	 * @see bom.BSEpisodes#getDescription()
	 */
	@Override
	public String getDescription() {
		this.updateDate();
		return super.getDescription();
	}

	/* (non-Javadoc)
	 * @see bom.BSEpisodes#setDescription(java.lang.String)
	 */
	@Override
	public void setDescription(String description) {
		this.updateDate();
		super.setDescription(description);
	}

	/* (non-Javadoc)
	 * @see bom.BSEpisodes#getDate()
	 */
	@Override
	public String getDate() {
		this.updateDate();
		return super.getDate();
	}

	/* (non-Javadoc)
	 * @see bom.BSEpisodes#setDate(java.lang.String)
	 */
	@Override
	public void setDate(String date) {
		this.updateDate();
		super.setDate(date);
	}
	
	/**
	 * @return the last_usage
	 */
	public Date getLast_usage() {
		return last_usage;
	}


}
