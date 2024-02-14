package com.annguyeen0.monopoly.service;

import com.annguyeen0.monopoly.model.TransactionTypeModel;

import java.util.List;

public interface TransactionTypeService {
    TransactionTypeModel findById(Integer id);
    TransactionTypeModel save(TransactionTypeModel data);
    List<TransactionTypeModel> findAll();
}
