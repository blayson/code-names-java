package cz.mendelu.pjj;

import java.util.Objects;

public class ClueLog {
    private String word;
    private int number;
    private Boolean isDone;
    private int numbersLeft;

    public int getNumbersLeft() {
        return numbersLeft;
    }

    public void setNumbersLeft(int numbersLeft) {
        this.numbersLeft = numbersLeft;
    }

    public ClueLog(String word, int number) {
        this.word = word;
        this.number = number;
        isDone = false;
        this.numbersLeft = number;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    public boolean isDone() {
        return isDone;
    }

    public String getWord() {
        return word;
    }

    public int getNumber() {
        return number;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClueLog)) return false;
        ClueLog clueLog = (ClueLog) o;
        return number == clueLog.number &&
                numbersLeft == clueLog.numbersLeft &&
                word.equals(clueLog.word) &&
                isDone.equals(clueLog.isDone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, number, isDone, numbersLeft);
    }
}
