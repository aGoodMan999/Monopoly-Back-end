package com.annguyeen0.monopoly.repository;

import com.annguyeen0.monopoly.model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<TransactionModel, Integer> {
    @Query(value = "SELECT * FROM transaction tr WHERE tr.game_id = ?1",nativeQuery = true)
    public List<TransactionModel> ngetTransactionByGameId(Integer gameId);
}
