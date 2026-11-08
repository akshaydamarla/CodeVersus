package com.codeversus.backend.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codeversus.backend.enums.Difficulty;
import com.codeversus.backend.exception.ProblemNotFoundException;
import com.codeversus.backend.model.Problem;
import com.codeversus.backend.repository.ProblemRepository;

@Service
public class ProblemService {
	
	private final ProblemRepository repository;
	
	public ProblemService(ProblemRepository repository) {
		this.repository = repository;
	}

	//retrieve all problems
	public List<Problem> getAllProblems(){
		return repository.findAll();
		
	}
	
	//retrieve problem by id
	public ResponseEntity<Problem> getProblemById(Long id) {
		Problem p1 = repository.findById(id)
				.orElseThrow(()->
				new ProblemNotFoundException("Problem not found with id: "+id));
		if(Boolean.TRUE.equals(p1.getEnabled())) {
			return ResponseEntity.ok(p1);
		}
		return ResponseEntity.notFound().build();
	}
	
	//Filter problems by difficulty
	public List<Problem> getProblems(Difficulty difficulty){
		List<Problem> problems = repository.findAll();
		List<Problem> response = new ArrayList<>();
		for(Problem p:problems) {
			if((Objects.equals(p.getDifficulty(),difficulty)||difficulty == null) && Boolean.TRUE.equals(p.getEnabled())) {
				response.add(p);
			}
		}
		return response;
	}
	

}
