package com.lcomputerstudy4.example.domain;

import java.util.List;

public class Question {

	
	private int qIdx;
	private int sIdx;
	private String qContent;
	private String qKind;
	private List<Item> itemList;
	
	
	public final int getqIdx() {
		return qIdx;
	}
	public final void setqIdx(int qIdx) {
		this.qIdx = qIdx;
	}
	public final int getsIdx() {
		return sIdx;
	}
	public final void setsIdx(int sIdx) {
		this.sIdx = sIdx;
	}
	public final String getqContent() {
		return qContent;
	}
	public final void setqContent(String qContent) {
		this.qContent = qContent;
	}
	public final String getqKind() {
		return qKind;
	}
	public final void setqKind(String qKind) {
		this.qKind = qKind;
	}
	public final List<Item> getItemList() {
		return itemList;
	}
	public final void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	
	
}
