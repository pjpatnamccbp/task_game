package com.game.restapis.controller;

import com.game.restapis.dto.ScoreDto;
import com.game.restapis.entity.Score;
import com.game.restapis.service.ScoreService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/score")
@AllArgsConstructor
public class ScoreController {

    private ScoreService scoreService;

    //localhost:8080/api/score/save
    //This request handler method is responsible for saving scores of a game in db
    @PostMapping("/save")
    public ResponseEntity<ScoreDto> saveScore(@Valid @RequestBody ScoreDto scoreDto){
        return new ResponseEntity<>(scoreService.saveScore(scoreDto), HttpStatus.CREATED);
    }

    //localhost:8080/api/score/query?gameId=3
    //This request handler method is responsible for retrieving high scores of a game by entering gameId from db
    @GetMapping("/get/query")
    public ResponseEntity<List<Integer>> getHighScoresByGameId(@RequestParam long gameId){
        return new ResponseEntity<>(scoreService.getHighScoresOfGame(gameId),HttpStatus.OK);
    }

    //localhost:8080/api/score/query?gameId=3&userName=Virat Kohli
    //This request handler method is responsible for retrieving high scores of a user in particular game
    // by entering gameId && userName from db
    @GetMapping("/query")
    public ResponseEntity<List<Integer>> getHighScoresByGameIdAndUsername(@RequestParam Long gameId,
                                                                          @RequestParam String userName
                                                                          ){
        return new ResponseEntity<>(scoreService.getHighScoresOfGameByUsername(gameId,userName),HttpStatus.OK);
    }
}
