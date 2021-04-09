package com.hacker.news.story.service;

import java.util.List;

import com.hacker.news.story.model.Comment;
import com.hacker.news.story.model.Story;

public interface IStory {
	
	public List<Story> bestStories();
	
	public List<Story> pastStories();
	
	public List<Comment> storyComments(Integer storyId);
	
}
