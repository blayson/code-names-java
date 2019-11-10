package cz.mendelu.pjj;

public class ClueLog {
    private String word;
    private int number;
    private Boolean isDone;

    public int getNumbersLeft() {
        return numbersLeft;
    }

    public void setNumbersLeft(int numbersLeft) {
        this.numbersLeft = numbersLeft;
    }

    private int numbersLeft;

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
}
