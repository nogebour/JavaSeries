package utils.queue;

import interfaces.IntBomObject;

public class BSAction {
	private BSActionEnum action;
	private IntBomObject object;
	
	public BSActionEnum getAction() {
		return action;
	}
	public void setAction(BSActionEnum action) {
		this.action = action;
	}
	public IntBomObject getObject() {
		return object;
	}
	public void setObject(IntBomObject object) {
		this.object = object;
	}

}
