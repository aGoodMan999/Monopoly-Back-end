package com.annguyeen0.monopoly.respone_model;

import com.annguyeen0.monopoly.model.Participation;
import com.annguyeen0.monopoly.model.TransactionModel;
import lombok.Data;

import java.util.Set;

@Data
public class PostTransactionModel {
    TransactionModel transaction;
    Set<Participation> participations;

    public PostTransactionModel(TransactionModel transaction, Set<Participation> participations) {
        this.transaction = transaction;
        this.participations = participations;
    }
}
