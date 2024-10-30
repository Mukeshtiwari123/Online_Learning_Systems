package com.demo.Online_Learning_Systems.Service;

import java.util.List;

import com.demo.Online_Learning_Systems.Entities.User;

public interface UserService {
	 public List<User> getUsers(); // Retrieve all users
	    public User getUser(long userId); // Retrieve a single user
	    public User addUser(User user); // Add a new user
	    public User updateUser(User user); // Update an existing user
	    public void deleteUser(long userId); // Delete a user
}
