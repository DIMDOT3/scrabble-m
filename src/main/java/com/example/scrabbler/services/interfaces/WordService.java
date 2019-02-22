package com.example.scrabbler.services.interfaces;

import com.example.scrabbler.repositories.models.*;

import java.util.List;

public interface WordService {

//  public List<Word> getAllWords();

  public Word addWord(String word);

  public void deleteWord(int wordId);

  public Word updateWord(int wordId);

//  public void checkIfWordIsValid(String word);
}