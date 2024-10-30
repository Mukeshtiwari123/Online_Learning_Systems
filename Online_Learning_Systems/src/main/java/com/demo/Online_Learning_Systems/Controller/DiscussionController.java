package com.demo.Online_Learning_Systems.Controller;

import com.demo.Online_Learning_Systems.Entities.Discussion;
import com.demo.Online_Learning_Systems.Service.DiscussionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discussions")
public class DiscussionController {

    @Autowired
    private DiscussionService discussionService;

    // Create a new discussion
    @PostMapping
    public ResponseEntity<Discussion> createDiscussion(@RequestBody Discussion discussion) {
        Discussion savedDiscussion = discussionService.addDiscussion(discussion);
        return ResponseEntity.ok(savedDiscussion);
    }

    // Get all discussions
    @GetMapping
    public ResponseEntity<List<Discussion>> getAllDiscussions() {
        List<Discussion> discussions = discussionService.getDiscussions();
        return ResponseEntity.ok(discussions);
    }

    // Get a discussion by ID
    @GetMapping("/{id}")
    public ResponseEntity<Discussion> getDiscussionById(@PathVariable Long id) {
        Discussion discussion = discussionService.getDiscussion(id);
        return ResponseEntity.ok(discussion);
    }

    // Update a discussion
    @PutMapping("/{id}")
    public ResponseEntity<Discussion> updateDiscussion(@PathVariable Long id, @RequestBody Discussion discussionDetails) {
        discussionDetails.setDiscussionId(id); // Set the ID to ensure the correct entity is updated
        Discussion updatedDiscussion = discussionService.updateDiscussion(discussionDetails);
        return ResponseEntity.ok(updatedDiscussion);
    }

    // Delete a discussion
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiscussion(@PathVariable Long id) {
        discussionService.deleteDiscussion(id);
        return ResponseEntity.noContent().build();
    }
}
