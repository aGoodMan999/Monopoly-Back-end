package com.annguyeen0.monopoly.repository;

import com.annguyeen0.monopoly.model.Participation;
import com.annguyeen0.monopoly.model.ParticipationPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipationRepository extends JpaRepository<Participation, ParticipationPK> {

}
