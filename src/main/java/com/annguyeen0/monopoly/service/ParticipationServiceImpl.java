package com.annguyeen0.monopoly.service;

import com.annguyeen0.monopoly.model.Participation;
import com.annguyeen0.monopoly.repository.ParticipationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ParticipationServiceImpl implements ParticipationService{

    private ParticipationRepository participationRepository;

    public ParticipationServiceImpl(ParticipationRepository participationRepository) {
        this.participationRepository = participationRepository;
    }

    @Override
    public List<Participation> getAll() {
        return this.participationRepository.findAll();
    }

    @Override
    public Participation getParticipationById(Integer id) {
        return participationRepository.findById(id).get();
    }

    @Override
    public Participation getParticipationByPlayerAndGame(Integer gameId, Integer playerId) {
        Participation p = this.participationRepository.getParticipationByGameIdAndGameId(gameId, playerId).get(0);
        return p;
    }

    @Override
    public Set<Participation> getParticipationByGame(Integer gameId) {
        return this.participationRepository.getParticipationByGameId(gameId);
    }


    @Override
    public Participation saveParticipation(Participation participation) {
        return this.participationRepository.save(participation);
    }

    @Override
    public Participation updateParticipation(Participation participation) {
        return this.participationRepository.save(participation);
    }

}
