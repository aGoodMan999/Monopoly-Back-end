package com.annguyeen0.monopoly.controller;

import com.annguyeen0.monopoly.model.Participation;
import com.annguyeen0.monopoly.service.ParticipationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParticipationController {

    ParticipationService participationService;

    public ParticipationController(ParticipationService participationService) {
        this.participationService = participationService;
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
