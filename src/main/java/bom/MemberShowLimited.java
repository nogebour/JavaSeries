package bom;

import interfaces.IntLimitedLifeTimeBom;

import java.util.Date;

public class MemberShowLimited extends MemberShow implements IntLimitedLifeTimeBom {
	private Date lastUsage;
	private boolean accessMode;
	
	public MemberShowLimited() {
		super();
		this.accessMode = true;
		this.updateDate();
	}

	public MemberShowLimited(Show show) {
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
