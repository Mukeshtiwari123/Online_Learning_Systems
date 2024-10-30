package com.demo.Online_Learning_Systems.ServiceImpl;

import com.demo.Online_Learning_Systems.Entities.User;
import com.demo.Online_Learning_Systems.Repository.UserRepository;
import com.demo.Online_Learning_Systems.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User userDetails) {
        User existingUser = userRepository.findById(userDetails.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userDetails.getUserId()));

        // Update basic user fields
        existingUser.setName(userDetails.getName());
        existingUser.setEmail(userDetails.getEmail());
        existingUser.setPassword(userDetails.getPassword());
        existingUser.setRole(userDetails.getRole());

        // Update enrolled courses if provided
        if (userDetails.getEnrolledCourses() != null) {
            existingUser.getEnrolledCourses().clear();
            existingUser.getEnrolledCourses().addAll(userDetails.getEnrolledCourses());
        }

        // Update attempted quizzes if provided
        if (userDetails.getAttemptedQuizzes() != null) {
            existingUser.getAttemptedQuizzes().clear();
            existingUser.getAttemptedQuizzes().addAll(userDetails.getAttemptedQuizzes());
        }

        return userRepository.save(existingUser);
    }


    @Override
    public void deleteUser(long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        userRepository.delete(user);
    }
}
