package com.annguyeen0.monopoly.service;


import com.annguyeen0.monopoly.model.TransactionTypeModel;
import com.annguyeen0.monopoly.repository.TransactionTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionTypeServiceImpl implements TransactionTypeService{

    private TransactionTypeRepository transactionTypeRepository;


    public TransactionTypeServiceImpl(TransactionTypeRepository transactionTypeRepository) {
        this.transactionTypeRepository = transactionTypeRepository;
    }

    @Override
    public TransactionTypeModel findById(Integer id) {
        return this.transactionTypeRepository.findById(id).get();
    }

    @Override
    public TransactionTypeModel save(TransactionTypeModel data) {



        return this.transactionTypeRepository.save(data);
    }

    @Override
    public List<TransactionTypeModel> findAll() {
        return this.transactionTypeRepository.findAll();
    }
}
