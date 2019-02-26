package com.example.scrabbler.services;

import com.example.scrabbler.repositories.PlayerRepository;
import com.example.scrabbler.repositories.models.Player;
import com.example.scrabbler.repositories.models.Word;
import com.example.scrabbler.services.interfaces.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player getPlayer(int playerId) {
        return playerRepository.findById(playerId).get();
    }

    @Override
    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }
    @Override
    public Player addPlayer(String name) {
        Player newPlayer = new Player();
        newPlayer.setPlayerName(name);
        playerRepository.save(newPlayer);
        return newPlayer;
    }

    public void addWord(Word word, int playerId) {
//        Player player = playerRepository.findById(playerId);
        Player player = (playerRepository.findById(playerId)).get();
        List<Word> words = player.getWords();
        words.add(word);
        player.setWords(words);
        playerRepository.save(player);
    }
}
