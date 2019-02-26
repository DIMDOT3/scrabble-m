package com.example.scrabbler.repositories.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "words")
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name="entry")
@XmlAccessorType(XmlAccessType.NONE)
//public class Word extends AuditModel {
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "word_id")
    private int wordId;
//    private int id;

//    @Column(name = "word")
    private String word;

//    @Column(name = "score")
    private int scrabblescore;

    @ManyToMany(mappedBy = "words")
    private List<Player> players;

    public Word() {}

    public Word(String word) {
        this.word = word;
    }

    public Word(String word, int scrabblescore) {
        this.word = word;
        this.scrabblescore = scrabblescore;
    }

//    @ManyToMany(mappedBy = "courses")
//    public int getWordId() {
//        return wordId;
//    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getScrabblescore() {
        return scrabblescore;
    }

    public void setScrabblescore(int scrabblescore) {
        this.scrabblescore = scrabblescore;
    }

//    public Set<Player> getPlayers() {
//        return players;
//    }
//
//    public void setPlayers(Set<Player> players) {
//        this.players = players;
//    }
}