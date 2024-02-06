package com.annguyeen0.monopoly.service;

import com.annguyeen0.monopoly.model.GameModel;
import com.annguyeen0.monopoly.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService{

    private GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public List<GameModel> getAllGame() {
        return this.gameRepository.findAll();
    }

    @Override
    public GameModel getGameById(Integer id) {
        return this.gameRepository.findById(id).orElse(null);
    }

    @Override
    public GameModel createNewGame(GameModel data) {
        return gameRepository.save(data);
    }
}
