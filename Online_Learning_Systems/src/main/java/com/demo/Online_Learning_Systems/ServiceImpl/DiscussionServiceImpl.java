package com.demo.Online_Learning_Systems.ServiceImpl;

import com.demo.Online_Learning_Systems.Entities.Discussion;
import com.demo.Online_Learning_Systems.Repository.DiscussionRepository;
import com.demo.Online_Learning_Systems.Service.DiscussionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussionServiceImpl implements DiscussionService {

    @Autowired
    private DiscussionRepository discussionRepository;

    @Override
    public List<Discussion> getDiscussions() {
        return discussionRepository.findAll();
    }

    @Override
    public Discussion getDiscussion(long discussionId) {
        return discussionRepository.findById(discussionId)
                .orElseThrow(() -> new RuntimeException("Discussion not found with id: " + discussionId));
    }

    @Override
    public Discussion addDiscussion(Discussion discussion) {
        return discussionRepository.save(discussion);
    }

    @Override
    public Discussion updateDiscussion(Discussion discussionDetails) {
        Discussion existingDiscussion = discussionRepository.findById(discussionDetails.getDiscussionId())
                .orElseThrow(() -> new RuntimeException("Discussion not found with id: " + discussionDetails.getDiscussionId()));

        // Update fields of the discussion
        existingDiscussion.setTopic(discussionDetails.getTopic());
        existingDiscussion.setComments(discussionDetails.getComments());

        // Update the course and user if provided
        if (discussionDetails.getCourse() != null) {
            existingDiscussion.setCourse(discussionDetails.getCourse());
        }
        if (discussionDetails.getUser() != null) {
            existingDiscussion.setUser(discussionDetails.getUser());
        }

        return discussionRepository.save(existingDiscussion);
    }


    @Override
    public void deleteDiscussion(long discussionId) {
        Discussion discussion = discussionRepository.findById(discussionId)
                .orElseThrow(() -> new RuntimeException("Discussion not found with id: " + discussionId));

        discussionRepository.delete(discussion);
    }
}
