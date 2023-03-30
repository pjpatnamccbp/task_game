package com.game.restapis.service;

import com.game.restapis.dto.ScoreDto;
import com.game.restapis.entity.Score;
import com.game.restapis.repository.ScoreRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ScoreServiceImpl implements ScoreService{

    @Autowired
    private ScoreRepository scoreRepository;

    private ModelMapper modelMapper;

    @Override
    public ScoreDto saveScore(ScoreDto scoreDto) {
        Score score = scoreRepository.save(modelMapper.map(scoreDto, Score.class));
        return modelMapper.map(score,ScoreDto.class);
    }

    @Override
    public List<Integer> getHighScoresOfGame(Long gameId) {

        return scoreRepository.findByGameId(gameId)
                .stream()
                .map(Score :: getScore)
                .sorted((s1,s2) -> s2-s1)
                .limit(10)
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> getHighScoresOfGameByUsername(Long gameId, String userName) {

        scoreRepository.findByGameIdAndUserName(gameId,userName).stream().forEach(System.out::println);

        return scoreRepository.findByGameIdAndUserName(gameId,userName)
                .stream()
                .map(Score :: getScore)
                .sorted((s1,s2) -> s2-s1)
                .limit(10)
                .collect(Collectors.toList());

    }
}
