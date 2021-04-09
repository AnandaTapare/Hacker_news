package com.hacker.news.story.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hacker.news.story.model.Comment;
import com.hacker.news.story.model.Story;
import com.hacker.news.story.service.IStory;

@RestController
public class StoryController {

	@Autowired
	IStory storyService;
	
	@GetMapping(value = "/best-stories")
	public List<Story> bestStory() {
		List<Story> bestStories = storyService.bestStories();
		return bestStories;
		
	}
	
	
	@GetMapping(value = "/past-stories")
	public List<Story> pastStory() {
		List<Story> bestStories = storyService.pastStories();
		return bestStories;
		
	}
	
	// storyComments
	@GetMapping(value = "{storyId}/comments")
	public List<Comment> storyComments(@PathVariable String storyId){
		return storyService.storyComments(Integer.parseInt(storyId));
	}
}
