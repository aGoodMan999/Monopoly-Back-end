package com.annguyeen0.monopoly.repository;

import com.annguyeen0.monopoly.model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionModel, Integer> {

}
