package com.annguyeen0.monopoly.controller;

import com.annguyeen0.monopoly.model.Participation;
import com.annguyeen0.monopoly.respone_model.GetParticipationByGameResponse;
import com.annguyeen0.monopoly.service.ParticipationService;
import com.annguyeen0.monopoly.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ParticipationController {

    ParticipationService participationService;
    PlayerService playerService;

    public ParticipationController(ParticipationService participationService, PlayerService playerService) {
        this.participationService = participationService;
        this.playerService = playerService;
    }
    @GetMapping("participations/get-by-game-and-id")
    public Participation getParticipationByPlayerAndGame(@RequestParam("gameId") Integer gameId, @RequestParam("playerId") Integer playerId){
        return this.participationService.getParticipationByPlayerAndGame(gameId, playerId);
    }

    @GetMapping("participations/get-by-game")
    public Set<GetParticipationByGameResponse> getParticipationInGame(@RequestParam("gameId") Integer gameId){
        Set<Participation> p = this.participationService.getParticipationByGame(gameId);
        Set<GetParticipationByGameResponse> res = new HashSet<>();
        p.stream().forEach(item-> {
            res.add(GetParticipationByGameResponse.builder()
                    .id(item.getId())
                    .gameId(item.getGameId())
                    .balance(item.getBalance())
                    .player(this.playerService.getPlayerById(item.getPlayerId() ))
                    .build()
            );
        });
        return res;
    }

    @GetMapping("participations")
    public List<Participation> getAllParticipation(){
        return this.participationService.getAll();
    }
    @PostMapping("participations")
    public Participation saveParticipation(@RequestBody Participation data){
        return this.participationService.saveParticipation(data);
    }


}
