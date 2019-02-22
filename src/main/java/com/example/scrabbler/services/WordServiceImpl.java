package com.example.scrabbler.services;


import com.example.scrabbler.repositories.WordRepository;
import com.example.scrabbler.repositories.models.Word;
import com.example.scrabbler.services.interfaces.WordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WordServiceImpl implements WordService {

  private WordRepository wordRepository;

  private static final Logger log = LoggerFactory.getLogger(Word.class);

  @Autowired
  RestTemplate restTemplate;

  @Autowired
  public WordServiceImpl(WordRepository wordRepository) {
    this.wordRepository = wordRepository;
  }

  // public List<Word> getWords() {
  // return wordRepository.findAll();
  // }

  @Override
  public Word addWord(String word) {
    Word checkedWord = checkIfWordIsValid(word);
    if(checkedWord.getScrabblescore() > 0) {
      wordRepository.save(checkedWord);
    }
    return checkedWord;
  }

  public void deleteWord(int wordId) {
    wordRepository.deleteById(String.valueOf(wordId));
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