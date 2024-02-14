package com.annguyeen0.monopoly.service;

import com.annguyeen0.monopoly.model.Participation;

import java.util.List;
import java.util.Set;

public interface ParticipationService {
    List<Participation> getAll();
    Participation getParticipationById(Integer id);
    Participation getParticipationByPlayerAndGame(Integer gameId, Integer playerId);
    Set<Participation> getParticipationByGame(Integer gameId);
    Participation saveParticipation(Participation participation);
    Participation updateParticipation(Participation participation);

}
