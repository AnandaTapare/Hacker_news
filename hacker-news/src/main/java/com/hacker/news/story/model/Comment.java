package com.hacker.news.story.model;

public class Comment {
	
	private String by;
	
	private String userTime;
	
	private String text;
	
	

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the by
	 */
	public String getBy() {
		return by;
	}

	/**
	 * @param by the by to set
	 */
	public void setBy(String by) {
		this.by = by;
	}

	/**
	 * @return the userTime
	 */
	public String getUserTime() {
		return userTime;
	}

	/**
	 * @param userTime the userTime to set
	 */
	public void setUserTime(String userTime) {
		this.userTime = userTime;
	}
}
