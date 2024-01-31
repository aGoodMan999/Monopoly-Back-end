package com.annguyeen0.monopoly.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;


public class ParticipationPK implements Serializable {
    private Integer gameId;
    private Integer playerId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticipationPK that = (ParticipationPK) o;
        return Objects.equals(gameId, that.gameId) && Objects.equals(playerId, that.playerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, playerId);
    }
}
