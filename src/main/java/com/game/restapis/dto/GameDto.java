package com.game.restapis.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GameDto {
    private Long gameId;
    @NotEmpty
    private String gameName;
    @NotEmpty
    private String description;
}
