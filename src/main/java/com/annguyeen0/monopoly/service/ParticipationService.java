package com.annguyeen0.monopoly.service;

import com.annguyeen0.monopoly.model.Participation;

import java.util.List;

public interface ParticipationService {
    List<Participation> getAll();
    Participation saveParticipation(Participation participation);
}
