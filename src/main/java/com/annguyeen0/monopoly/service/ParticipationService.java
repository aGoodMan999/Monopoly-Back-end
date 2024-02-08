package com.annguyeen0.monopoly.service;

import com.annguyeen0.monopoly.model.Participation;

import java.util.List;

public interface ParticipationService {
    List<Participation> getAll();
    Participation getParticipationById(Integer id);
    Participation getParticipationByPlayerAndGame(Integer gameId, Integer playerId);
    Participation saveParticipation(Participation participation);
    Participation updateParticipation(Participation participation);

}
