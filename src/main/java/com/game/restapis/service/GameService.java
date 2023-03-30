package com.game.restapis.service;

import com.game.restapis.dto.GameDto;

public interface GameService {
    Long createGame(GameDto gameDto);
}
