package com.lcomputerstudy4.example.domain;

import java.util.List;

public class Survey {

	private int sIdx;
	private int uIdx;
	private String sTitle;
	private String sContent;
	private String sDatetime;
	private User user;
	private Question question;
	List<Question> questionList;
	
	
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
	public final User getUser() {
		return user;
	}
	public final void setUser(User user) {
		this.user = user;
	}
	public final String getsContent() {
		return sContent;
	}
	public final void setsContent(String sContent) {
		this.sContent = sContent;
	}
	public final List<Question> getQuestionList() {
		return questionList;
	}
	public final void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}
	public final Question getQuestion() {
		return question;
	}
	public final void setQuestion(Question question) {
		this.question = question;
	}

}
