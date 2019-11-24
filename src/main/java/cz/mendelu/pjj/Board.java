package cz.mendelu.pjj;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Board {
    private ArrayList<Word> wordList; // But

    Board() {
        wordList = new ArrayList<>(25);
    }

    public Word getWord(int position) {
        return wordList.get(position);
    }

    public ArrayList<Word> getWordList() {
        return wordList;
    }

    public void createWordList() {
        generateWords();
        shuffleWords();
    }

    public void shuffleWords() {
        Collections.shuffle(wordList, new Random());
    }

    public void generateWords() {
        for (int i = 0; i < 25; i++) {
            wordList.add(0, new Word("apple" + i));
        }
    }
}
