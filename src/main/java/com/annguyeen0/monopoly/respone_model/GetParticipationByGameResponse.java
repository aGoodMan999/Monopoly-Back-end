package com.annguyeen0.monopoly.respone_model;

import com.annguyeen0.monopoly.model.Participation;
import com.annguyeen0.monopoly.model.PlayerModel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetParticipationByGameResponse {
    Integer id;
    Integer gameId;
    Integer balance;
    PlayerModel player;
}
