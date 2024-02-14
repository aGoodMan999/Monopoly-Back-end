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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PlayerController {

    PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("players")
    public List<PlayerModel> getAll(){
        return playerService.getAllPlayer().stream().filter(player -> !player.getName().equals("bank")).toList();
    }
    @GetMapping("players/get-list-player")
    Set<PlayerModel> getPlayersByListId(@RequestBody Set<Integer> listId){
        return this.playerService.getPlayerByListId(listId);
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
