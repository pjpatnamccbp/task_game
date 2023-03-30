package com.game.restapis.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ScoreDto {
    private Long scoreId;
    @NotEmpty
    private Long gameId;
    @NotEmpty
    private String userName;
    @NotEmpty
    private int score;
    private LocalDateTime dateSubmitted;
}
