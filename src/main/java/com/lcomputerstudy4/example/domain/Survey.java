package com.lcomputerstudy4.example.domain;

public class Survey {

	private int sIdx;
	private int uIdx;
	private String sTitle;
	private String sDatetime;
	
	
	public final int getsIdx() {
		return sIdx;
	}
	public final void setsIdx(int sIdx) {
		this.sIdx = sIdx;
	}
	public final int getuIdx() {
		return uIdx;
	}
	public final void setuIdx(int uIdx) {
		this.uIdx = uIdx;
	}
	public final String getsTitle() {
		return sTitle;
	}
	public final void setsTitle(String sTitle) {
		this.sTitle = sTitle;
	}
	public final String getsDatetime() {
		return sDatetime;
	}
	public final void setsDatetime(String sDatetime) {
		this.sDatetime = sDatetime;
	}
}
