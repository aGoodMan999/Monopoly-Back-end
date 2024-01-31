package com.annguyeen0.monopoly.service;

import com.annguyeen0.monopoly.model.PlayerModel;

import java.util.List;

public interface PlayerService {
    List<PlayerModel> getAllPlayer();
    PlayerModel getPlayerById(Integer id);

    PlayerModel createPlayer(PlayerModel data);
}
