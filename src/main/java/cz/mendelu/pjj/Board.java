package cz.mendelu.pjj;



import java.util.ArrayList;

public class Board {
    ArrayList<Word> wordList;

    public Word getWord(int position) {
        return wordList.get(position);
    }


    public ArrayList<Word> getWordList() {
        return wordList;
    }


    public void createWords() {
        wordList = generateWords();


    }


    public ArrayList<Word> generateWords(){
        return null;
    }


}
