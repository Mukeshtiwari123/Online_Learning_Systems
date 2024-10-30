package com.demo.Online_Learning_Systems.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Discussion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long discussionId;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String topic;
    private String comments; // JSON string or array
	
    
    public Discussion(Course course, User user, String topic, String comments) {
		super();
		this.course = course;
		this.user = user;
		this.topic = topic;
		this.comments = comments;
	}


	public Long getDiscussionId() {
		return discussionId;
	}


	public void setDiscussionId(Long discussionId) {
		this.discussionId = discussionId;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getTopic() {
		return topic;
	}


	public void setTopic(String topic) {
		this.topic = topic;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	public Discussion() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Discussion [discussionId=" + discussionId + ", course=" + course + ", user=" + user + ", topic=" + topic
				+ ", comments=" + comments + "]";
	}
    
    
}

