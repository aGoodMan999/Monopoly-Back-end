package com.annguyeen0.monopoly.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transaction")
public class TransactionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "game_id")
    private Integer gameId;
    @Column(name = "sender_id")
    private Integer senderId;
    @Column(name = "receiver_id")
    private Integer receiverId;
    @Column(name = "time")
    private Date time;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "transaction_type_id", referencedColumnName = "id")
    @JsonManagedReference
    private TransactionTypeModel transactionType;
}
