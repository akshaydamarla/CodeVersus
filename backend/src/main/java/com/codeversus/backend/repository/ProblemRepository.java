package com.codeversus.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.codeversus.backend.model.Problem;

public interface ProblemRepository extends JpaRepository<Problem, Long>{
	
}
