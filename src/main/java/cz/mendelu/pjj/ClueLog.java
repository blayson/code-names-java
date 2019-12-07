package cz.mendelu.pjj;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ClueLog {
    private Boolean isDone;
    /**
     * @author Chuprina
     * @version etapa 3
     */
    private Map<String, Integer> wordList = new HashMap<String, Integer>(); // key - word, value - int word counter
    private String currentWord;
    private int unguessedCounter;


    public ClueLog() {
        isDone = false;
        unguessedCounter = 0;
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
        currentWord = word;
        unguessedCounter = unguessedCounter + number;
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
            unguessedCounter--;
        }
    }

    public void decreaseWordCounter() {
        unguessedCounter--;
    }

    /**
     * @return words Map without guessed words
     * @author But
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

    public int getUnguessedCounter() {
        return unguessedCounter;
    }

    public void setUnguessedCounter(int unguessedCounter) {
        this.unguessedCounter = unguessedCounter;
    }

    /**
     * @author Chuprina
     * @version etapa 3
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClueLog clueLog = (ClueLog) o;
        return unguessedCounter == clueLog.unguessedCounter &&
                isDone.equals(clueLog.isDone) &&
                wordList.equals(clueLog.wordList) &&
                currentWord.equals(clueLog.currentWord);
    }

    /**
     * @author Chuprina
     * @version etapa 3
     */
    @Override
    public int hashCode() {
        return Objects.hash(isDone, wordList, currentWord, unguessedCounter);
    }

    public String getCurrentWord() {
        return currentWord;
    }

    public void setCurrentWord(String currentWord) {
        this.currentWord = currentWord;
    }

    /**
     * @author Chuprina
     * @version etapa 3
     */
    @Override
    public String toString() {
        return "ClueLog{" +
                "isDone=" + isDone +
                ", wordList=" + wordList +
                ", currentWord='" + currentWord + '\'' +
                ", unguessedCounter=" + unguessedCounter +
                '}';
    }
}
