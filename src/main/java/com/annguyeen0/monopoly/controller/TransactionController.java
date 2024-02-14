package com.annguyeen0.monopoly.controller;


import com.annguyeen0.monopoly.model.Participation;
import com.annguyeen0.monopoly.model.TransactionModel;
import com.annguyeen0.monopoly.model.TransactionTypeModel;
import com.annguyeen0.monopoly.request_model.NewTransactionRequest;
import com.annguyeen0.monopoly.respone_model.PostTransactionModel;
import com.annguyeen0.monopoly.service.ParticipationService;
import com.annguyeen0.monopoly.service.TransactionService;
import com.annguyeen0.monopoly.service.TransactionTypeService;
import org.hibernate.Transaction;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TransactionController {

    private TransactionService transactionService;
    private TransactionTypeService transactionTypeService;
    private ParticipationService participationService;



    public TransactionController(TransactionService transactionService, TransactionTypeService transactionTypeService, ParticipationService participationService) {
        this.transactionService = transactionService;
        this.transactionTypeService = transactionTypeService;
        this.participationService = participationService;
    }



    @GetMapping("transactions")
    public List<TransactionModel> getAllTransaction(){
        return transactionService.getAllTransaction();
    }

    @GetMapping("transactions/get-type")
    public List<TransactionTypeModel> getAllTransactionType() {
        return this.transactionTypeService.findAll();
    }

    @GetMapping("transactions/get-by-game-id")
    public List<TransactionModel> getTransactionByGameId(@RequestParam("gameId") Integer gameId){
        return this.transactionService.getTransactionByGameId(gameId);
    }

    @PostMapping("transactions")
    public PostTransactionModel createNewTransaction(@RequestBody NewTransactionRequest data) {
        TransactionTypeModel transactionType = this.transactionTypeService.findById(data.getType());
        TransactionModel transaction = TransactionModel.builder()
                .time(new Date())
                .gameId(data.getGameId())
                .senderId(data.getSenderId())
                .receiverId(data.getReceiverId())
                .transactionType(transactionType)
                .build();

        //Update balance for both sender and receiver
        Participation sender = this.participationService.getParticipationByPlayerAndGame(data.getGameId(), data.getSenderId());
        Participation receiver = this.participationService.getParticipationByPlayerAndGame(data.getGameId(), data.getReceiverId());
        sender.setBalance(sender.getBalance() - transactionType.getCost());
        receiver.setBalance(receiver.getBalance() + transactionType.getCost());

        this.participationService.saveParticipation(sender);
        this.participationService.saveParticipation(receiver);

        return new PostTransactionModel(this.transactionService.save(transaction), this.participationService.getParticipationByGame(data.getGameId()));


    }
}
