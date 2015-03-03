package bom;

import interfaces.IntLimitedLifeTimeBom;

import java.util.Date;

public class BSMemberShowLimited extends BSMemberShow implements IntLimitedLifeTimeBom {
	private Date lastUsage;
	private boolean accessMode;
	
	public BSMemberShowLimited() {
		this.updateDate();
	}

	public BSMemberShowLimited(BSShow show) {
		super(show);
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

	/* (non-Javadoc)
	 * @see bom.IntLimitedLifeTimeBom#getLast_usage()
	 */
	public Date getLastUsage() {
		return lastUsage;
	}

}
