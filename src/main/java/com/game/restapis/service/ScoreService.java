package com.game.restapis.service;

import com.game.restapis.dto.ScoreDto;

import java.util.List;

public interface ScoreService {
    ScoreDto saveScore(ScoreDto scoreDto);

    List<Integer> getHighScoresOfGame(Long gameId);
    List<Integer> getHighScoresOfGameByUsername(Long gameId,String userName);
}
