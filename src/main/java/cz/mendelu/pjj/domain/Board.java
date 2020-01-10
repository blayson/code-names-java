package cz.mendelu.pjj.domain;


import org.json.simple.JSONArray;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Board implements Serializable {
    /**
     * @author But
     * @version etapa 3
     */
    private List<Word> wordList = new ArrayList<>(25); // But

    public Board() {
//        wordList = new ArrayList<>(25);
    }

    public Word getWord(int position) {
        return wordList.get(position);
    }

    public List<Word> getWordList() {
        return wordList;
    }

    public void createWordList(JSONArray array) {
        generateWords(array);
        shuffleWords();
    }

    public void shuffleWords() {
        Collections.shuffle(wordList, new Random());
    }


    public void generateWords(JSONArray array) {
        for (Object word : array) {
            wordList.add(new Word(word.toString()));
        }
    }



}
