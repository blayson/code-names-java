package cz.mendelu.pjj;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodeNamesGameTest {
    private static CodeNamesGame game;

    @BeforeAll
    static void setUp() {
        game = new CodeNamesGame(Level.EASY, new Player("Andrew"), null, Turn.PLAYER);
    }

    @Test
    void checkClueLogDoesNotHasTries() {
        ClueLog[] newClueLog = new ClueLog[2];
        newClueLog[0] = new ClueLog("apple", 1);
        newClueLog[1] = new ClueLog("pencil", 2);
        game.setLog(newClueLog);

        int result = game.checkClueLog();

        assertEquals(3, result);
    }

    @Test
    void checkClueLogHasTries() {
        ClueLog[] newClueLog = new ClueLog[1];
        newClueLog[0] = new ClueLog("apple", 1);
        newClueLog[0].setNumbersLeft(0);
        game.setLog(newClueLog);

        int result = game.checkClueLog();

        assertEquals(0, result);
    }

    @Test
    void nextTurn() {
        game.nextTurn();
        assertEquals(game.currentTurn, Turn.OPPONENT);
    }
}