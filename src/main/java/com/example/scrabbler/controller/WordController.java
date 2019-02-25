package com.example.scrabbler.controller;

import com.example.scrabbler.domains.WordRequestBody;
import com.example.scrabbler.repositories.models.Word;
import com.example.scrabbler.services.interfaces.WordService;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/scrabbler")
@CrossOrigin

public class WordController {
    private WordService wordService;

    @Autowired
    public WordController(WordService wordService) {this.wordService = wordService;}

    @GetMapping("/words")
    public List<Word> getWords() {
       return wordService.getWords();
    }

    @PostMapping("/words")
    public Word word(@RequestBody(required = false) WordRequestBody wordRequestBody) {
        String word = wordRequestBody.getWord();
        int playerId = wordRequestBody.getPlayerId();
        Word newWord = wordService.addWord(word, playerId);
        return newWord;
    }
}