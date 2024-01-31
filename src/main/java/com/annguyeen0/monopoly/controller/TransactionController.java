package com.annguyeen0.monopoly.controller;


import com.annguyeen0.monopoly.model.TransactionModel;
import com.annguyeen0.monopoly.service.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {

    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("transactions")
    public List<TransactionModel> getAllTransaction(){
        return transactionService.getAllTransaction();
    }
}
