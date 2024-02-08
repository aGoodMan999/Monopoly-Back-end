package com.annguyeen0.monopoly.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "participation")
public class Participation {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "game_id")
    private Integer gameId;

    @Column(name = "player_id")
    private Integer playerId;

    @Column(name = "balance")
    private Integer balance;
//    @ManyToOne
//    @JoinColumn(name = "game_id")
//    private GameModel game;
//
//    @ManyToOne
//    @JoinColumn(name = "player_id")
//    private PlayerModel player;
}
