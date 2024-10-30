package com.demo.Online_Learning_Systems.Service;

import java.util.List;

import com.demo.Online_Learning_Systems.Entities.Discussion;

public interface DiscussionService {
	public List<Discussion> getDiscussions(); // Retrieve all discussions
    public Discussion getDiscussion(long discussionId); // Retrieve a single discussion
    public Discussion addDiscussion(Discussion discussion); // Add a new discussion
    public Discussion updateDiscussion(Discussion discussion); // Update an existing discussion
    public void deleteDiscussion(long discussionId); // Delete a discussion

}
