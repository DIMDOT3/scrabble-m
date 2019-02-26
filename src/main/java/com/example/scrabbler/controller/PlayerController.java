package com.example.scrabbler.controller;

import com.example.scrabbler.domains.PlayerRequestBody;
import com.example.scrabbler.repositories.models.Player;
import com.example.scrabbler.services.interfaces.PlayerService;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/scrabbler")
@CrossOrigin
public class PlayerController {
    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {this.playerService = playerService;}

    @GetMapping("/players")
    public List<Player> getPlayers() {
        return playerService.getPlayers();
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody(required = false) PlayerRequestBody playerRequestBody) {
        Player newPlayer = playerService.addPlayer(playerRequestBody.getName());
        return newPlayer;
    }

    @GetMapping("/players/{id}")
    public Player getPlayer(@PathVariable int id) {
        return playerService.getPlayer(id);
    }

    //    @GetMapping("/words/{id}")
////    public List<Word> getPlayerWords
}
