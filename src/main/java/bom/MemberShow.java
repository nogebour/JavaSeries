package bom;

import interfaces.IntBomObject;

import java.util.List;

public class MemberShow implements IntBomObject{
	private Show show;
	private long note;
	private long remaining;
	private List<Episode> remainingEpisodes;
	
	public MemberShow(){
		super();
	}
	
	public MemberShow(Show show){
		super();
		this.show = show;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
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
