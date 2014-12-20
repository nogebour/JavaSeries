package bom;

public class BSMemberShow {
	private BSShow show;
	private long note;
	private long remaining;
	
	public BSMemberShow(){
		super();
	}
	
	public BSMemberShow(BSShow show){
		super();
		this.show = show;
	}

	public BSShow getShow() {
		return show;
	}

	public void setShow(BSShow show) {
		this.show = show;
	}

	public long getNote() {
		return note;
	}

	public void setNote(long note) {
		this.note = note;
	}

	public long getRemaining() {
		return remaining;
	}

	public void setRemaining(long remaining) {
		this.remaining = remaining;
	}
	
}
