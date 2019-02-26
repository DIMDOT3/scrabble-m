package com.example.scrabbler.controller;

import com.example.scrabbler.repositories.models.Word;
import com.example.scrabbler.services.interfaces.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scrabbler")
@CrossOrigin

public class WordController {
    private WordService wordService;

    @Autowired
    public WordController(WordService wordService) {this.wordService = wordService;}

    @GetMapping("/words")
    public List<Word> getAllWords() {
       return wordService.getAllWords();
    }

    @GetMapping("/words/{id}")
    public Word getWord(@PathVariable int id) {
        return wordService.getWord(id);
    }
}