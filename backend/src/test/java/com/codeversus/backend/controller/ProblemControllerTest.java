package com.codeversus.backend.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.codeversus.backend.enums.Difficulty;
import com.codeversus.backend.exception.ProblemNotFoundException;
import com.codeversus.backend.model.Problem;
import com.codeversus.backend.service.ProblemService;

@WebMvcTest(ProblemController.class)
public class ProblemControllerTest {
	
	@Autowired
	private MockMvc mocMvc;
	
	@MockitoBean
	private ProblemService problemService;
	
	@Test
	void getProblemById_whenFound_returns200AndHidesInternalFields() throws Exception{
		Problem problem = new Problem(1L, "Pair With Target Sum", "pair-with-target-sum",
                Difficulty.EASY, List.of("array", "hash-map"), "CODEVERSUS", null, true);
		
		given(problemService.getProblemById(1L)).willReturn(problem);
		
		mocMvc.perform(get("/api/v1/problems/1"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.id").value(1))
		.andExpect(jsonPath("$.title").value("Pair With Target Sum"))
        .andExpect(jsonPath("$.difficulty").value("EASY"))
        .andExpect(jsonPath("$.enabled").doesNotExist())
        .andExpect(jsonPath("$.source").doesNotExist());
	}
	
	 @Test
	 void getProblemById_whenMissing_returns404WithApiError() throws Exception {
	        given(problemService.getProblemById(99L))
	                .willThrow(new ProblemNotFoundException("Problem not found with id: 99"));

	        mocMvc.perform(get("/api/v1/problems/99"))
	                .andExpect(status().isNotFound())
	                .andExpect(jsonPath("$.status").value(404))
	                .andExpect(jsonPath("$.error").value("Not Found"))
	                .andExpect(jsonPath("$.message").value("Problem not found with id: 99"));
	  }

}
