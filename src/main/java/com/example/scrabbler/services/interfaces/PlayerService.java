package com.example.scrabbler.services.interfaces;

import com.example.scrabbler.repositories.models.*;

import java.util.List;

public interface PlayerService {

    public List<Player> getPlayers();
    public Player addPlayer(String word);

//    public void deleteWord(int wordId);
//
//    public Word updateWord(int wordId);
}
