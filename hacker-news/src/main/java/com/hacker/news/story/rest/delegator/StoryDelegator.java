package com.hacker.news.story.rest.delegator;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.hacker.news.story.model.Comment;
import com.hacker.news.story.model.Story;
import com.hacker.news.story.model.User;

@Component
public class StoryDelegator {

	private static final String BEST_STORIES_API = "topstories.json?print=pretty";

	private static final String BASE_URL = "https://hacker-news.firebaseio.com/v0/";
	
	private static final String TYPE_URL = "item/";
	
	private static final String USER_URL = "user/";

	private static final String EXT = ".json";

	@Autowired
	public RestTemplate restTemplate;

	public List<Story> getTopStory(boolean topFlag) {

		List<Integer> list = this.getBestStoires();

		List<Story> topStories = new LinkedList<Story>();
		// For now 10 is hardcode we can cofigure in the property file and inject value of top
		for (int i = 0; i < (topFlag ? 10 : list.size()); i++) {
			topStories.add(getStory(list.get(i)));
		}
		return topStories;
	}

	private List<Integer> getBestStoires() {
		List<Integer> bestStories = restTemplate.getForObject(BASE_URL + BEST_STORIES_API, List.class);
		if (bestStories != null) {
			Collections.sort(bestStories);
		}
		return bestStories;
	}
	
	public Story getStory(Integer storyId) {
		return restTemplate.getForObject(BASE_URL + TYPE_URL + storyId + EXT, Story.class);
	}
	
	public Comment getComment(String commentId) {
		return restTemplate.getForObject(BASE_URL + TYPE_URL + commentId + EXT, Comment.class);
	}
	
	public User getUser(String userId) {
		return restTemplate.getForObject(BASE_URL + USER_URL + userId + EXT, User.class);
	}
}
