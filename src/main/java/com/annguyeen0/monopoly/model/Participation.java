package com.annguyeen0.monopoly.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "participation")
@IdClass(ParticipationPK.class)
public class Participation {
    @Id
    @Column(name = "game_id")
    private Integer gameId;
    @Id
    @Column(name = "player_id")
    private Integer playerId;
}
