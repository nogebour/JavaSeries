package factory;

import bom.BSShowCenter;
import bom.BSShowCenterLimited;

public class FacShowCenter {
	public final static FacShowCenter INSTANCE = new FacShowCenter();
	private final static BSShowCenter INSTANCE_SHOW_CENTER = new BSShowCenterLimited();
	private FacShowCenter() {
	}
	
	public BSShowCenter getShowCenter(){
		return INSTANCE_SHOW_CENTER;
	}

}
