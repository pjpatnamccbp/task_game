package com.game.restapis.controller;

import com.game.restapis.dto.GameDto;
import com.game.restapis.service.GameService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/game")
@AllArgsConstructor
public class GameController {
    private GameService gameService;

    //localhost:8080/api/game/create
    //This request handler method is responsible for creating game in db
    @PostMapping("/create")
    public ResponseEntity<Long> createGame(@Valid @RequestBody GameDto gameDto){
        return new ResponseEntity<>(gameService.createGame(gameDto), HttpStatus.CREATED);
    }
}
