package com.example.scrabbler.repositories.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "players")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Player extends AuditModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int playerId;
  private String playerName;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "player_words", joinColumns = { @JoinColumn(name = "player_id") }, inverseJoinColumns = { @JoinColumn(name = "word_id") })
  private List<Word> words;

  public Player() {}

  public Player(String playerName) {
    this.playerName = playerName;
  }

//  public Player(String playerName, List<Word> words) {
//    this.playerName = playerName;
//    this.words = words;
//  }

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

  public List<Word> getWords() {
    return words;
  }

  public void setWords(List<Word> words) {
    this.words = words;
  }
}