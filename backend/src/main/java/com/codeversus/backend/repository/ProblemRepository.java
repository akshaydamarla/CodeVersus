package com.codeversus.backend.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeversus.backend.enums.Difficulty;
import com.codeversus.backend.model.Problem;

public interface ProblemRepository extends JpaRepository<Problem, Long>{
	
	List<Problem> findByEnabledTrue();
	
	List<Problem> findByDifficultyAndEnabledTrue(Difficulty difficulty);
	
	Optional<Problem> findProblemByIdAndEnabledTrue(long id);
	
}
