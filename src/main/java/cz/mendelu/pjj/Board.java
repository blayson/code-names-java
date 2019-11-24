package cz.mendelu.pjj;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Board {
    private ArrayList<Word> wordList; // But

    public Word getWord(int position) {
        return wordList.get(position);
    }


    public ArrayList<Word> getWordList() {
        return wordList;
    }


    public void createWordList() {
        wordList = generateWords();
        shuffleAgents();

    }
    public void shuffleAgents() {
        Collections.shuffle(wordList, new Random());
    }

    public ArrayList<Word> generateWords(){
        wordList.add(0, new Word("apple"));
        wordList.add(1, new Word("melon"));
        wordList.add(2, new Word("word"));
        wordList.add(3, new Word("world"));
        wordList.add(4, new Word("water"));
        wordList.add(5, new Word("apple1"));
        wordList.add(6, new Word("melon1"));
        wordList.add(7, new Word("word1"));
        wordList.add(8, new Word("world1"));
        wordList.add(9, new Word("water1"));
        wordList.add(10, new Word("apple2"));
        wordList.add(11, new Word("melon2"));
        wordList.add(12, new Word("word2"));
        wordList.add(13, new Word("world2"));
        wordList.add(14, new Word("water2"));
        wordList.add(15, new Word("apple2"));
        wordList.add(16, new Word("melon2"));
        wordList.add(17, new Word("word2"));
        wordList.add(18, new Word("world2"));
        wordList.add(19, new Word("water2"));
        wordList.add(20, new Word("apple2"));
        wordList.add(21, new Word("melon2"));
        wordList.add(22, new Word("word2"));
        wordList.add(23, new Word("world2"));
        wordList.add(24, new Word("water2"));
        wordList.add(25, new Word("apple2"));
        return null;
    }


}
