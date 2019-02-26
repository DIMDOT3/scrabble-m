package com.example.scrabbler.services.interfaces;

import com.example.scrabbler.repositories.models.Player;
import com.example.scrabbler.repositories.models.Word;

import java.util.List;

public interface PlayerService {

    public Player getPlayer(int playerId);
    public List<Player> getPlayers();
    public Player addPlayer(String word);
//    public Optional<Player> getPlayer(int playerId);
    public void addWord(Word word, int playerId);

//    public void deleteWord(int wordId);
//
//    public Word updateWord(int wordId);
}
