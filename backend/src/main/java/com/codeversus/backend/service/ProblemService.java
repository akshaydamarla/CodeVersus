package com.codeversus.backend.service;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codeversus.backend.enums.Difficulty;
import com.codeversus.backend.exception.ProblemNotFoundException;
import com.codeversus.backend.model.Problem;
import com.codeversus.backend.repository.ProblemRepository;


@Service
@Transactional(readOnly = true)
public class ProblemService {
	
	private final ProblemRepository repository;
	
	public ProblemService(ProblemRepository repository) {
		this.repository = repository;
	}

	/*//retrieve all problems
	public List<Problem> getAllProblems(){
		return repository.findAll();
		
	}*/
	
	//retrieve problem by id
	public Problem getProblemById(Long id) {
		return repository.findProblemByIdAndEnabledTrue(id)
				.orElseThrow(()-> new ProblemNotFoundException("Problem not found with id: "+id));
	}
	
	//Filter problems by difficulty
	public List<Problem> getProblems(Difficulty difficulty){
		return (difficulty==null)?repository.findByEnabledTrue():repository.findByDifficultyAndEnabledTrue(difficulty);
	}
	

}
