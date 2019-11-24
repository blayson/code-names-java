package cz.mendelu.pjj;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ClueLog {


    private Boolean isDone;
    private int numbersLeft;
    Map< String, Integer> wordList = new HashMap < String, Integer>(); // key - word, value - int

    public int getNumbersLeft() {
        return numbersLeft;
    }

    public void setNumbersLeft(int numbersLeft) {
        this.numbersLeft = numbersLeft;
    }

    public ClueLog() {

       wordList = null;
        isDone = false;

    }
    public void addWord(String word, int number) {
         if (wordList.containsKey(word)){
             throw new AddAnExistingWordException();
         }
        wordList.put(word,number);
    }
    public void removeWord(String word) {
        wordList.remove(word);
    }



    public void decreaseNumber(String word) {

        wordList.put(word, wordList.get(word) - 1);

    }

    public int getNumber(String word) {
        if (wordList.containsKey(word)){
            return wordList.get(word);
        }
        return 0; // vyjimka - ?
    }


    public void setDone(Boolean done) {
        isDone = done;
    }

    public boolean isDone() {
        return isDone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClueLog)) return false;
        ClueLog clueLog = (ClueLog) o;
        return numbersLeft == clueLog.numbersLeft &&
                Objects.equals(isDone, clueLog.isDone) &&
                Objects.equals(wordList, clueLog.wordList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isDone, numbersLeft, wordList);
    }
}
