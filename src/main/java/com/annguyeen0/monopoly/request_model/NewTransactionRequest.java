package com.annguyeen0.monopoly.request_model;

import com.annguyeen0.monopoly.model.TransactionModel;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class NewTransactionRequest {
    Integer gameId;
    Integer senderId;
    Integer receiverId;
    Integer type;
}
