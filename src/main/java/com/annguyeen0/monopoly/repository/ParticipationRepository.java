package com.annguyeen0.monopoly.repository;

import com.annguyeen0.monopoly.model.Participation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ParticipationRepository extends JpaRepository<Participation, Integer> {

    @Query(
            value = "SELECT * FROM participation p WHERE p.game_id = ?1 and p.player_id = ?2",
            nativeQuery = true)
    List<Participation> getParticipationByGameIdAndGameId(Integer gameId, Integer playerId);
}
