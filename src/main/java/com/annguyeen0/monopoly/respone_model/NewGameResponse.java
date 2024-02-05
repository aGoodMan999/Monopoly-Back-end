package com.annguyeen0.monopoly.respone_model;

import com.annguyeen0.monopoly.model.GameModel;
import com.annguyeen0.monopoly.model.PlayerModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewGameResponse {
    GameModel gameData;
    List<PlayerModel> listPlayer;
}
