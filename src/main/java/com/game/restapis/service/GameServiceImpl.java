package com.game.restapis.service;

import com.game.restapis.dto.GameDto;
import com.game.restapis.entity.Game;
import com.game.restapis.repository.GameRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GameServiceImpl implements GameService {

    private GameRepository gameRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Long createGame(GameDto gameDto) {
        Game game = gameRepository.save(modelMapper.map(gameDto, Game.class));
        return modelMapper.map(game,GameDto.class).getGameId();
    }
}
