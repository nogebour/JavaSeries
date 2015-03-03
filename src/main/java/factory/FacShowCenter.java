package factory;

import bom.BSShowCenter;

public class FacShowCenter {
	public final static FacShowCenter INSTANCE = new FacShowCenter();
	private final static BSShowCenter INSTANCE_SHOW_CENTER = new BSShowCenter();
	private FacShowCenter() {
	}
	
	public BSShowCenter getShowCenter(){
		return INSTANCE_SHOW_CENTER;
	}

}
