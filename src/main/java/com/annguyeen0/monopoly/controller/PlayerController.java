package com.annguyeen0.monopoly.controller;

import com.annguyeen0.monopoly.model.PlayerModel;
import com.annguyeen0.monopoly.repository.PlayerRepository;
import com.annguyeen0.monopoly.service.PlayerService;
import com.annguyeen0.monopoly.service.PlayerServiceImpl;
import org.hibernate.annotations.Parameter;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PlayerController {

    PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("players")
    public List<PlayerModel> getAll(){

        return playerService.getAllPlayer();
    }

    @GetMapping("players/{id}")
    public PlayerModel getById(@PathVariable int id){
        return playerService.getPlayerById(id);
    }

    @PostMapping("players")
    public PlayerModel createPlayer(@RequestBody PlayerModel data){
        return playerService.createPlayer(data);
    }

}
