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
    checkIfWordIsValid(word);
    Word newWord = new Word();
//    int score = calculateScore(word);
//    newWord.setScore(score);
//    newWord.setWord(word);
//    wordRepository.save(newWord);
    return newWord;
  }

  public void deleteWord(int wordId) {
    wordRepository.deleteById(String.valueOf(wordId));
  }

  public Word updateWord(int wordId) {
    Word word = new Word();
    return word;
  }

  private void checkIfWordIsValid(String word) {
    String url = String.format("http://www.wordgamedictionary.com/api/v1/references/scrabble/%s?key=API_KEY", word);
    try {
      log.info("attempting to call");
      Word response = restTemplate.getForObject(url, Word.class);
      log.info("call completed");
      System.out.println(response);
    } catch (Exception e) {
      log.info(e.getMessage());
    }
  }

  private int calculateScore(String word) {
    int score = 0;

    char[] scrabbleWordArray = word.toLowerCase().toCharArray();
    for (char a : scrabbleWordArray) {
      score += scoreFor(a);

    }
    return score;
  }

  private int scoreFor(char letter) {
    switch (letter) {
    case 'd':
    case 'g':
      return 2;

    case 'b':
    case 'c':
    case 'm':
    case 'p':
      return 3;

    case 'f':
    case 'h':
    case 'v':
    case 'w':
    case 'y':
      return 4;

    case 'k':
      return 5;

    case 'j':
    case 'x':
      return 8;

    case 'z':
    case 'q':
      return 10;

    default:
      return 1;

    }
  }
}