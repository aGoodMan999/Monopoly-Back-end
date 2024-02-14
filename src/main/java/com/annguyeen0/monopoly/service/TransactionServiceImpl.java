package com.annguyeen0.monopoly.service;

import com.annguyeen0.monopoly.model.GameModel;
import com.annguyeen0.monopoly.model.TransactionModel;
import com.annguyeen0.monopoly.repository.GameRepository;
import com.annguyeen0.monopoly.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    private TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<TransactionModel> getAllTransaction() {
        return transactionRepository.findAll();
    }

    @Override
    public List<TransactionModel> getTransactionByGameId(Integer id) {
        return this.transactionRepository.ngetTransactionByGameId(id);
    }

    @Override
    public TransactionModel save(TransactionModel data) {
        return this.transactionRepository.save(data);
    }
}
