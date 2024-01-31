package com.annguyeen0.monopoly.service;

import com.annguyeen0.monopoly.model.GameModel;
import com.annguyeen0.monopoly.model.TransactionModel;

import java.util.List;

public interface TransactionService {
    List<TransactionModel> getAllTransaction();
}
