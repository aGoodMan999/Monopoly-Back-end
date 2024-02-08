package com.annguyeen0.monopoly.request_model;
import com.annguyeen0.monopoly.model.GameStatusModel;
import com.annguyeen0.monopoly.model.PlayerModel;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class NewGameRequest {
    Integer initTotal;
    List<Integer> listPlayerId;
}
