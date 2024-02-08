package com.annguyeen0.monopoly.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "game")
public class GameModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "created_time")
    private Date createDate;
    @Column(name = "last_modified")
    private Date lastModified;
    @Column(name = "init_total")
    private Integer initTotal;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "win_by_id", referencedColumnName = "id")
    @JsonManagedReference
    private WinByModel win_by;

    @ManyToOne( cascade = CascadeType.MERGE)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    @JsonManagedReference
    private GameStatusModel gameStatus;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "participation",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private Set<PlayerModel> players;
}
