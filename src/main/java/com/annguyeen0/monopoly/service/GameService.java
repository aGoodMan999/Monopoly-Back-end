package com.annguyeen0.monopoly.service;

import com.annguyeen0.monopoly.model.GameModel;

import java.util.List;

public interface GameService {
    List<GameModel> getAllGame();

    GameModel getGameById(Integer id);
    GameModel createNewGame(GameModel data);
}
