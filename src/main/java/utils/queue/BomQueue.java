package utils.queue;

import java.util.Collection;
import java.util.LinkedList;


public class BomQueue extends LinkedList<BomAction> {

	/**
	 * serialVersionUIDGenerated
	 */
	private static final long serialVersionUID = 6648038867784410562L;
	
	public BomQueue() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BomQueue(Collection<? extends BomAction> c) {
		super(c);
		// TODO Auto-generated constructor stub
	}
	
}
