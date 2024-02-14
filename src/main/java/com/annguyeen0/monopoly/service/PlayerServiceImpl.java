package com.annguyeen0.monopoly.service;

import com.annguyeen0.monopoly.model.PlayerModel;
import com.annguyeen0.monopoly.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class PlayerServiceImpl implements PlayerService{

    PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<PlayerModel> getAllPlayer() {
        return this.playerRepository.findAll();
    }

    @Override
    public PlayerModel getPlayerById(Integer id) {
        Optional<PlayerModel> data = this.playerRepository.findById(id);
        return data.orElse(null);
    }

    @Override
    public PlayerModel createPlayer(PlayerModel data) {
        PlayerModel finalData = PlayerModel.builder()
                .name(data.getName())
                .createDate(new Date())
                .build();
        return playerRepository.save(finalData);
    }

    @Override
    public Set<PlayerModel> getPlayerByListId(Set<Integer> listId) {
        Set<PlayerModel> res = new HashSet<>();
        for (Integer id:
             listId) {
            res.add(this.playerRepository.findById(id).orElse(null));
        }
        return res;
    }
}
