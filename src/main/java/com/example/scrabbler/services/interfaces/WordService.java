package com.example.scrabbler.services.interfaces;

import com.example.scrabbler.repositories.models.*;

import java.util.List;

public interface WordService {

  public List<Word> getAllWords();

  public Word getWord(int id);

  public Word checkIfWordIsValid(String word);
}