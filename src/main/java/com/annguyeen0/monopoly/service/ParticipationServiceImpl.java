package com.annguyeen0.monopoly.service;

import com.annguyeen0.monopoly.model.Participation;
import com.annguyeen0.monopoly.repository.ParticipationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Participation saveParticipation(Participation participation) {
        return this.participationRepository.save(participation);
    }

}
