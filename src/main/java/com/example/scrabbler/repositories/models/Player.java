package com.example.scrabbler.repositories.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "players")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Player extends AuditModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int playerId;
  private String playerName;

  public int getPlayerId() {
    return playerId;
  }

  public void setPlayerId(int playerId) {
    this.playerId = playerId;
  }

  public String getPlayerName() {
    return playerName;
  }

  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }
}