package com.example.scrabbler.controller;

import com.example.scrabbler.domains.PlayerRequestBody;
import com.example.scrabbler.repositories.models.Player;
import com.example.scrabbler.services.interfaces.PlayerService;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class PlayerController {
    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {this.playerService = playerService;}

//    @CrossOrigin
//    @RequestMapping("/player")
//    public Player player(@RequestParam(value = "player", defaultValue = "World") String player) {
//        Player newPlayer = playerService.addPlayer(player);
//        return newPlayer;
//    }
    @CrossOrigin
    @PostMapping("/player")
    public Player player(@RequestBody(required = false) PlayerRequestBody playerRequestBody) {
        Player newPlayer = playerService.addPlayer(playerRequestBody.getName());
        return newPlayer;
    }
}
