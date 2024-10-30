package com.demo.Online_Learning_Systems.Service;

import java.util.List;

import com.demo.Online_Learning_Systems.Entities.Quiz;

public interface QuizService {
	public List<Quiz> getQuizzes(); // Retrieve all quizzes
    public Quiz getQuiz(long quizId); // Retrieve a single quiz
    public Quiz addQuiz(Quiz quiz); // Add a new quiz
    public Quiz updateQuiz(Quiz quiz); // Update an existing quiz
    public void deleteQuiz(long quizId); // Delete a quiz
}
