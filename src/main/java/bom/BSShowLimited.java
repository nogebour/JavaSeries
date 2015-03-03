package bom;

import interfaces.IntLimitedLifeTimeBom;

import java.util.Date;

public class BSShowLimited extends BSShow implements IntLimitedLifeTimeBom {
	private Date last_usage;
	
	public BSShowLimited() {
		super();
		this.updateDate();
	}

	private void updateDate() {
		last_usage = new Date();
	}
	
	public Date getLast_usage() {
		return last_usage;
	}

}
