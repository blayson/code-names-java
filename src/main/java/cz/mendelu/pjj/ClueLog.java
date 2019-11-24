package cz.mendelu.pjj;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ClueLog {
    private Boolean isDone;
    private Map<String, Integer> wordList = new HashMap<String, Integer>(); // key - word, value - int word counter


    public ClueLog() {
        isDone = false;
    }

    public void addWord(String word, int number) {
        if (wordList.containsKey(word)) {
            throw new AddAnExistingWordException(); // @author Chuprina
        }
        if (number <= 0 || number >= 9) {
            throw new ZeroNumbersOfCluesException(); // @author But
        }
        isDone = false;
        wordList.put(word, number);
    }

    public void removeWord(String word) {
        wordList.remove(word);
    }

    /**
     * pokud hrac vybral spravne slovo, snizi se mu pocet agentu, kterych musi jeste odhadnout o 1
     *
     * @param word given word from the UI
     */
    public void decreaseWordCounter(String word) {
        if (wordList.get(word) != 0) {
            wordList.put(word, wordList.get(word) - 1);
        }
    }

    /**
     * @author But
     * @return words Map without guessed words
     */
    public Map getWordsToGuess() {
        Map<String, Integer> words = new HashMap<String, Integer>();
        for (Map.Entry<String, Integer> clue : wordList.entrySet()) {
            Integer wordClueCount = clue.getValue();
            if (wordClueCount > 0) {
                words.put(clue.getKey(), clue.getValue());
            }
        }
        return words;
    }

    public void setWordCounter(String word, int num) {
        wordList.put(word, num);
    }

    public int getWordCounter(String word) {
        if (wordList.containsKey(word)) {
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

    public Map<String, Integer> getWordList() {
        return wordList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClueLog clueLog = (ClueLog) o;
        return isDone.equals(clueLog.isDone) &&
                wordList.equals(clueLog.wordList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isDone, wordList);
    }
}
