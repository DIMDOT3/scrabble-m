package com.example.scrabbler.services.interfaces;

import com.example.scrabbler.repositories.models.*;

public interface WordService {

  public Word addWord(String word);

  public void deleteWord(int wordId);

  public Word updateWord(int wordId);

//  public void checkIfWordIsValid(String word);
}