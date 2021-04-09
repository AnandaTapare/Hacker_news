package com.hacker.news.story.model;

import java.util.List;

public class Story {
	private String title;
	private String url;
	private String score;
	private String time;
	private String by;
	
	@JsonIgnore
	private List<String> kids;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the score
	 */
	public String getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(String score) {
		this.score = score;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
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
	 * @return the kids
	 */
	public List<String> getKids() {
		return kids;
	}

	/**
	 * @param kids the kids to set
	 */
	public void setKids(List<String> kids) {
		this.kids = kids;
	}

	@Override
	public String toString() {
		return "Story [title=" + title + ", url=" + url + ", score=" + score + ", time=" + time + ", by=" + by + "]";
	}

}
