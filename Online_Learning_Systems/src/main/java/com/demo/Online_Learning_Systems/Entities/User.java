package com.demo.Online_Learning_Systems.Entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    private String name;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToMany
    @JoinTable(name = "enrollments",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> enrolledCourses;

    @ManyToMany
    @JoinTable(name = "quiz_attempts",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "quiz_id"))
    private List<Quiz> attemptedQuizzes;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Course> getEnrolledCourses() {
		return enrolledCourses;
	}

	public void setEnrolledCourses(List<Course> enrolledCourses) {
		this.enrolledCourses = enrolledCourses;
	}

	public List<Quiz> getAttemptedQuizzes() {
		return attemptedQuizzes;
	}

	public void setAttemptedQuizzes(List<Quiz> attemptedQuizzes) {
		this.attemptedQuizzes = attemptedQuizzes;
	}

	public User(String name, String email, String password, Role role, List<Course> enrolledCourses,
			List<Quiz> attemptedQuizzes) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.enrolledCourses = enrolledCourses;
		this.attemptedQuizzes = attemptedQuizzes;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password + ", role="
				+ role + ", enrolledCourses=" + enrolledCourses + ", attemptedQuizzes=" + attemptedQuizzes + "]";
	}
    
    
}
