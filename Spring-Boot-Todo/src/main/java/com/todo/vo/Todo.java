package com.todo.vo;

public class Todo {
	private int num;
	private String content;
	private String userId;
	private String sdate;
	private String edate;
	private char done;
	public Todo(int num, String content, String userId, String sdate, String edate, char done) {
		super();
		this.num = num;
		this.content = content;
		this.userId = userId;
		this.sdate = sdate;
		this.edate = edate;
		this.done = done;
	}
	public Todo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
	public char getDone() {
		return done;
	}
	public void setDone(char done) {
		this.done = done;
	}
	public Todo(String content, String userId, String sdate, String edate, char done) {
		super();
		this.content = content;
		this.userId = userId;
		this.sdate = sdate;
		this.edate = edate;
		this.done = done;
	}
	public Todo(String content, String userId, String sdate, String edate) {
		super();
		this.content = content;
		this.userId = userId;
		this.sdate = sdate;
		this.edate = edate;
	}
	
}