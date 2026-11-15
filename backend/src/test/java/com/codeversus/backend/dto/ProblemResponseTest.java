package com.codeversus.backend.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.codeversus.backend.enums.Difficulty;
import com.codeversus.backend.model.Problem;

public class ProblemResponseTest {
	
	@Test
	void from_copiesFieldsFromTheEntity() {
		Problem problem = new Problem(
				1L,
				"Pair With Target Sum",
				"pair-with-target-sum",
				Difficulty.EASY,
				List.of("array","hash-map"),
				"CODEVERSUS",
				null,
				true
				);
		
		ProblemResponse response = ProblemResponse.from(problem);
		
		assertThat(response.id()).isEqualTo(1L);
		assertThat(response.difficulty()).isEqualTo(Difficulty.EASY);
		assertThat(response.title()).isEqualTo("Pair With Target Sum");
		assertThat(response.slug()).isEqualTo("pair-with-target-sum");
		assertThat(response.topics()).containsExactly("array","hash-map");
		
		
	}

}
