package com.annguyeen0.monopoly.repository;

import com.annguyeen0.monopoly.model.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<GameModel, Integer> {
}
