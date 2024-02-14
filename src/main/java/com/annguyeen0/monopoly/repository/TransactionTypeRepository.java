package com.annguyeen0.monopoly.repository;

import com.annguyeen0.monopoly.model.TransactionTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionTypeRepository extends JpaRepository<TransactionTypeModel, Integer> {
}
