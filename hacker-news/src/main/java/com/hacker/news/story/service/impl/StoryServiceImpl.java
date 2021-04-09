package com.hacker.news.story.service.impl;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hacker.news.story.model.Comment;
import com.hacker.news.story.model.Story;
import com.hacker.news.story.model.User;
import com.hacker.news.story.rest.delegator.StoryDelegator;
import com.hacker.news.story.service.IStory;

@Service
public class StoryServiceImpl implements IStory {

	@Autowired
	private StoryDelegator delegator;

	private List<Story> topStoriesCached;

	private List<Story> topAllStoriesCached;

	private LocalTime topStoryCachedTime;

	private LocalTime topALLStoryCachedTime;

	@Override
	public List<Story> bestStories() {
		if (null != topStoryCachedTime) {
			LocalTime now = LocalTime.now();
			long mins = Duration.between(topStoryCachedTime, now).toMinutes();
			// coditional time is hard coded we can configure
			if (mins < 15) {
				return topStoriesCached;
			}
		}

		List<Story> topStories = delegator.getTopStory(true);
		topStoriesCached = topStories;
		topStoryCachedTime = LocalTime.now();
		return topStoriesCached;
	}

	@Override
	public List<Story> pastStories() {
		if (null != topALLStoryCachedTime) {
			LocalTime now = LocalTime.now();
			long mins = Duration.between(topALLStoryCachedTime, now).toMinutes();
			if (mins < 15) {
				return topAllStoriesCached;
			}
		}

		List<Story> topAllStories = delegator.getTopStory(false);
		topAllStoriesCached = topAllStories;
		topALLStoryCachedTime = LocalTime.now();
		return topAllStoriesCached;
	}

	@Override
	public List<Comment> storyComments(Integer storyId) {
		Story story = delegator.getStory(storyId);
		List<Comment> comments = new LinkedList<Comment>();
		List<String> list = story.getKids();
		Comment comment=null;
		User user = null;
		Calendar c = Calendar.getInstance();
		for(int i=0;i<(list.size() < 10 ? list.size() : 10 );i++){
			comment = callCommentsApi(list.get(i));
			user = callUserApi(comment.getBy());
			if(user != null) {
			c.setTimeInMillis(user.getCreated().longValue());
			int year = Calendar.getInstance().get(Calendar.YEAR)-c.get(Calendar.YEAR);
			comment.setUserTime(year+" years");
			comments.add(comment);
			}
		}
		return comments;
	}

	private User callUserApi(String userId) {
		return delegator.getUser(userId);
	}

	private Comment callCommentsApi(String commentId) {
		return delegator.getComment(commentId);
	}
	
	

}
