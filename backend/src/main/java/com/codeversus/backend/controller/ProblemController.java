package com.codeversus.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codeversus.backend.enums.Difficulty;
import com.codeversus.backend.model.Problem;
import com.codeversus.backend.service.ProblemService;

@RestController
@RequestMapping("/api/v1")

public class ProblemController {
	
	private final ProblemService problemService;

	public ProblemController(ProblemService problemService) {
		this.problemService = problemService;
	}
	
	@GetMapping("/problems")
	public List<Problem> getProblemsbyDifficulty(@RequestParam(required = false) Difficulty difficulty){
		return problemService.getProblems(difficulty);
	}
	
	@GetMapping("/problems/{id}")
	public Problem getProblemById(@PathVariable Long id) {
		return problemService.getProblemById(id);
	}
	

}
