package utils.queue;

import interfaces.IntBomObject;

public class BomAction {
	private BomActionEnum action;
	private IntBomObject object;
	
	public BomActionEnum getAction() {
		return action;
	}
	public void setAction(BomActionEnum action) {
		this.action = action;
	}
	public IntBomObject getObject() {
		return object;
	}
	public void setObject(IntBomObject object) {
		this.object = object;
	}

}
