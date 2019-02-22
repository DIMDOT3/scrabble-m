package com.example.scrabbler.controller;

import com.example.scrabbler.repositories.models.Word;
import com.example.scrabbler.services.interfaces.WordService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
public class WordController {
    private WordService wordService;

    @Autowired
    public WordController(WordService wordService) {this.wordService = wordService;}

    @CrossOrigin
    @RequestMapping("/word")
    public Word word(@RequestParam(value = "word", defaultValue = "World") String word) {
        Word newWord = wordService.addWord(word);
        return newWord;
    }
}