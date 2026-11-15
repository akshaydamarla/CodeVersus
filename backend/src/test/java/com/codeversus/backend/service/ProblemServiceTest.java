package com.codeversus.backend.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.codeversus.backend.enums.Difficulty;
import com.codeversus.backend.exception.ProblemNotFoundException;
import com.codeversus.backend.model.Problem;
import com.codeversus.backend.repository.ProblemRepository;

@ExtendWith(MockitoExtension.class)
class ProblemServiceTest {

    @Mock
    private ProblemRepository repository;

    @InjectMocks
    private ProblemService service;

    @Test
    void getProblems_withoutDifficulty_returnsAllEnabledProblems() {
        List<Problem> enabled = List.of(
                problem(1L, Difficulty.EASY),
                problem(2L, Difficulty.HARD));
        given(repository.findByEnabledTrue()).willReturn(enabled);

        List<Problem> result = service.getProblems(null);

        assertThat(result).hasSize(2);
        verify(repository).findByEnabledTrue();
    }

    @Test
    void getProblems_withDifficulty_filtersByDifficulty() {
        List<Problem> easy = List.of(problem(1L, Difficulty.EASY));
        given(repository.findByDifficultyAndEnabledTrue(Difficulty.EASY)).willReturn(easy);

        List<Problem> result = service.getProblems(Difficulty.EASY);

        assertThat(result).containsExactlyElementsOf(easy);
        verify(repository).findByDifficultyAndEnabledTrue(Difficulty.EASY);
    }

    @Test
    void getProblemById_whenFound_returnsProblem() {
        Problem problem = problem(1L, Difficulty.EASY);
        given(repository.findProblemByIdAndEnabledTrue(1L)).willReturn(Optional.of(problem));

        Problem result = service.getProblemById(1L);

        assertThat(result).isSameAs(problem);
    }

    @Test
    void getProblemById_whenMissingOrDisabled_throwsProblemNotFoundException() {
        given(repository.findProblemByIdAndEnabledTrue(99L)).willReturn(Optional.empty());

        assertThatThrownBy(() -> service.getProblemById(99L))
                .isInstanceOf(ProblemNotFoundException.class)
                .hasMessageContaining("99");
    }

    private Problem problem(Long id, Difficulty difficulty) {
        return new Problem(id, "Title " + id, "slug-" + id, difficulty,
                List.of("array"), "CODEVERSUS", null, true);
    }
}