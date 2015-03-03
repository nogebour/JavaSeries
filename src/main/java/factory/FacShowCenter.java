package factory;

import bom.ShowCenter;
import bom.ShowCenterLimited;

public class FacShowCenter {
	public final static FacShowCenter INSTANCE = new FacShowCenter();
	private final static ShowCenter INSTANCE_SHOW_CENTER = new ShowCenterLimited();
	private FacShowCenter() {
	}
	
	public ShowCenter getShowCenter(){
		return INSTANCE_SHOW_CENTER;
	}

}
