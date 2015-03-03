package utils.queue;

import interfaces.IntBomObject;

public class BomAction {
	private ActionEnum action;
	private IntBomObject object;
	
	public ActionEnum getAction() {
		return action;
	}
	public void setAction(ActionEnum action) {
		this.action = action;
	}
	public IntBomObject getObject() {
		return object;
	}
	public void setObject(IntBomObject object) {
		this.object = object;
	}

}
