package com.annguyeen0.monopoly.service;

import com.annguyeen0.monopoly.model.GameModel;
import com.annguyeen0.monopoly.model.Participation;
import com.annguyeen0.monopoly.model.TransactionModel;
import com.annguyeen0.monopoly.repository.GameRepository;
import com.annguyeen0.monopoly.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService{

    private TransactionRepository transactionRepository;
    private ParticipationService participationService;

    public TransactionServiceImpl(TransactionRepository transactionRepository, ParticipationService participationService) {
        this.transactionRepository = transactionRepository;
        this.participationService = participationService;
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

    @Override
    public TransactionModel deleteById(Integer id) {
        Optional<TransactionModel> res = this.transactionRepository.findById(id);
        if(res.isPresent()){
            Integer cost = res.get().getTransactionType().getCost();
            Participation receiver = this.participationService
                    .getParticipationByPlayerAndGame(res.get().getGameId(), res.get().getReceiverId());
            Participation sender = this.participationService
                    .getParticipationByPlayerAndGame(res.get().getGameId(), res.get().getSenderId());

            receiver.setBalance(receiver.getBalance() - cost);
            sender.setBalance(sender.getBalance() + cost);

            this.transactionRepository.deleteById(id);
            this.participationService.saveParticipation(receiver);
            this.participationService.saveParticipation(sender);
            return res.get();
        }
        return null;

    }
}
