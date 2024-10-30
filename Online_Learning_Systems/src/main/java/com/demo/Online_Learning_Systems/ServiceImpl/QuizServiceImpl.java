package com.demo.Online_Learning_Systems.ServiceImpl;

import com.demo.Online_Learning_Systems.Entities.Quiz;
import com.demo.Online_Learning_Systems.Repository.QuizRepository;
import com.demo.Online_Learning_Systems.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public List<Quiz> getQuizzes() {
        return quizRepository.findAll();
    }

    @Override
    public Quiz getQuiz(long quizId) {
        return quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found with id: " + quizId));
    }

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quizDetails) {
        Quiz existingQuiz = quizRepository.findById(quizDetails.getQuizId())
                .orElseThrow(() -> new RuntimeException("Quiz not found with id: " + quizDetails.getQuizId()));

        // Update fields of the quiz
        existingQuiz.setQuestion(quizDetails.getQuestion());
        existingQuiz.setOption1(quizDetails.getOption1());
        existingQuiz.setOption2(quizDetails.getOption2());
        existingQuiz.setOption3(quizDetails.getOption3());
        existingQuiz.setOption4(quizDetails.getOption4());
        existingQuiz.setCorrectOption(quizDetails.getCorrectOption());
        existingQuiz.setMaxScore(quizDetails.getMaxScore());
        existingQuiz.setPassingScore(quizDetails.getPassingScore());

        // Update course if provided
        if (quizDetails.getCourse() != null) {
            existingQuiz.setCourse(quizDetails.getCourse());
        }

        return quizRepository.save(existingQuiz);
    }

    @Override
    public void deleteQuiz(long quizId) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found with id: " + quizId));

        quizRepository.delete(quiz);
    }
}
