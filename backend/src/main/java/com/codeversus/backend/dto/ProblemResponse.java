package com.codeversus.backend.dto;

import java.util.List;

import com.codeversus.backend.enums.Difficulty;
import com.codeversus.backend.model.Problem;

public record ProblemResponse(
		Long id,
		String title,
		String slug,
		Difficulty difficulty,
		List<String> topics,
		String referenceUrl) {
	
	public static ProblemResponse from(Problem problem) {
		return new ProblemResponse(
				problem.getId(),
				problem.getTitle(),
				problem.getSlug(),
				problem.getDifficulty(),
				problem.getTopics(),
				problem.getReferenceUrl());
	}
	

}
