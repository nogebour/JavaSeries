package bom;

import java.util.Date;

public class BSMemberShowLimited extends BSMemberShow implements IntLimitedLifeTimeBom {
	private Date last_usage;
	
	public BSMemberShowLimited() {
		this.updateDate();
	}

	public BSMemberShowLimited(BSShow show) {
		super(show);
		this.updateDate();
	}

	private void updateDate() {
		last_usage = new Date();
	}

	/* (non-Javadoc)
	 * @see bom.IntLimitedLifeTimeBom#getLast_usage()
	 */
	public Date getLast_usage() {
		return last_usage;
	}

}
