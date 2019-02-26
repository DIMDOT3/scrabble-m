package com.example.scrabbler.services;


import com.example.scrabbler.repositories.WordRepository;
import com.example.scrabbler.repositories.models.Word;
import com.example.scrabbler.services.interfaces.PlayerService;
import com.example.scrabbler.services.interfaces.WordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class WordServiceImpl implements WordService {

  private WordRepository wordRepository;
  private PlayerService playerService;

  private static final Logger log = LoggerFactory.getLogger(Word.class);

  @Autowired
  RestTemplate restTemplate;

  @Autowired
  public WordServiceImpl(WordRepository wordRepository, PlayerService playerService) {
    this.wordRepository = wordRepository;
    this.playerService = playerService;
  }

   public List<Word> getAllWords() {
//    List<Word> wordsList = new ArrayList<>();
    List<Word> words = wordRepository.findAll();
    return words;
   }

   public Word getWord(int id) {
    return wordRepository.findById(id).get();
   }

  @Override
  public Word addWord(String word, int playerId) {
    Word checkedWord = checkIfWordIsValid(word);
    if(checkedWord.getScrabblescore() > 0) {
      playerService.addWord(checkedWord, playerId);
//      wordRepository.save(checkedWord);
    }
    return checkedWord;
  }

  public void deleteWord(int wordId) {
    wordRepository.deleteById(wordId);
  }

  public Word updateWord(int wordId) {
    Word word = new Word();
    return word;
  }

  private Word checkIfWordIsValid(String word) {
    String url = String.format("http://www.wordgamedictionary.com/api/v1/references/scrabble/%s?key=1.119936904369512e30", word);
    Word response = restTemplate.getForObject(url, Word.class);
    return response;
    //    try {
//      log.info("attempting to call");
//      Word response = restTemplate.getForObject(url, Word.class);
//      log.info("call completed");
//      System.out.println(response);
//    } catch (Exception e) {
//      log.info(e.getMessage());
//    }
  }
}