package com.demo.Online_Learning_Systems.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.Online_Learning_Systems.Entities.*;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

}
