package com.codeversus.backend.controller;

import com.codeversus.backend.dto.ProblemResponse;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codeversus.backend.enums.Difficulty;
import com.codeversus.backend.service.ProblemService;

@RestController
@RequestMapping("/api/v1")

public class ProblemController {
	
	private ProblemResponse problemResponse;
	private final ProblemService problemService;

	public ProblemController(ProblemService problemService) {
		this.problemService = problemService;
	}
	
	@GetMapping("/problems")
	public List<ProblemResponse> getProblemsbyDifficulty(@RequestParam(required = false) Difficulty difficulty){
		return (problemService.getProblems(difficulty)).stream()
				.map(ProblemResponse::from)
				.toList();
	}
	
	@GetMapping("/problems/{id}")
	public ProblemResponse getProblemById(@PathVariable Long id) {
		return problemResponse.from(problemService.getProblemById(id));
	}
	

}
