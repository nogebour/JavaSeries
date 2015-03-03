package factory;

import bom.Show;
import bom.ShowLimited;

public class FacShow {
	public final static FacShow INSTANCE = new FacShow();
	
	public FacShow(){
	}
	
	public Show getNewShow(){
		Show episode = new ShowLimited();
		return episode;
	}
}
