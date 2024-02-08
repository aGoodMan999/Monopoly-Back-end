package com.annguyeen0.monopoly.controller;

import com.annguyeen0.monopoly.model.GameModel;
import com.annguyeen0.monopoly.model.GameStatusModel;
import com.annguyeen0.monopoly.model.Participation;
import com.annguyeen0.monopoly.model.PlayerModel;
import com.annguyeen0.monopoly.request_model.NewGameRequest;
import com.annguyeen0.monopoly.respone_model.NewGameResponse;
import com.annguyeen0.monopoly.service.GameService;
import com.annguyeen0.monopoly.service.ParticipationService;
import com.annguyeen0.monopoly.service.PlayerService;
import com.annguyeen0.monopoly.service.PlayerServiceImpl;
import org.hibernate.annotations.Parameter;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class GameController {

    private GameService gameService;
    private ParticipationService participationService;

    private PlayerService playerService;

    public GameController(GameService gameService, ParticipationService participationService, PlayerService playerService) {
        this.gameService = gameService;
        this.participationService = participationService;
        this.playerService = playerService;
    }

    @GetMapping("games")
    public List<GameModel> getAllGame(){
        return this.gameService.getAllGame();
    }

    @GetMapping("games/{id}")
    public GameModel getGameById(@PathVariable("id") Integer id){
        return this.gameService.getGameById(id);
    }
    @PostMapping("games")
    public GameModel createNewGame(@RequestBody NewGameRequest data) {
        GameStatusModel status = GameStatusModel.builder().id(1).build();
//        GameModel finalData = GameModel.builder()
//                .gameStatus(status)
//                .initTotal(data.getInitTotal())
//                .createDate(new Date())
//                .lastModified(new Date())
//                .build();
//        GameModel res = gameService.createNewGame(finalData);
//        for(Integer item : data.getListPlayerId()){
//            participationService.saveParticipation(new Participation(res.getId(), item, res.getInitTotal()));
//        }
        //Lấy tất cả player bằng id từ request
        Set<PlayerModel> listPlayer = new HashSet<>();
        for(Integer id : data.getListPlayerId()){
            listPlayer.add(this.playerService.getPlayerById(id));
        }

        GameModel finalData = GameModel.builder()
                .players(listPlayer)
                .lastModified(new Date())
                .createDate(new Date())
                .initTotal(data.getInitTotal())
                .gameStatus(status)
                .build();
        GameModel res = this.gameService.createNewGame(finalData);

        listPlayer.stream().forEach(playerModel -> {
            Participation target = this.participationService.getParticipationByPlayerAndGame(res.getId(), playerModel.getId());
            target.setBalance(res.getInitTotal());
            this.participationService.updateParticipation(target);
        });;

        return res;
    }
}
