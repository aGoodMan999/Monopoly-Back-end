package com.annguyeen0.monopoly.repository;

import com.annguyeen0.monopoly.model.PlayerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<PlayerModel, Integer> {

}
