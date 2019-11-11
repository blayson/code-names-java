package cz.mendelu.pjj;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodeNamesGameTest {
    private static CodeNamesGame game;

    /**
     * Setup <code>CodeNamesGame</code> object for testing
     */
    @BeforeAll
    static void setUp() {
        game = new CodeNamesGame(Level.HARD, new Player("Andrew"), null, Turn.PLAYER);
    }

    /**
     * Test checkClue() method when all cards wasn't guessed
     */
    @Test
    void checkClueLogDoesNotHasTries() {
        ClueLog[] newClueLog = new ClueLog[2];
        newClueLog[0] = new ClueLog("apple", 1);
        newClueLog[1] = new ClueLog("pencil", 2);
        game.setLog(newClueLog);

        int result = game.checkClueLog();

        assertEquals(3, result);
    }

    /**
     * Test <code>checkClue()<code/> method when all cards was guessed
     */
    @Test
    void checkClueLogHasTries() {
        ClueLog[] newClueLog = new ClueLog[1];
        newClueLog[0] = new ClueLog("apple", 1);
        newClueLog[0].setNumbersLeft(0);
        game.setLog(newClueLog);

        int result = game.checkClueLog();

        assertEquals(0, result);
    }

    /**
     * Test if <code>nextTurn()<code/> switch game turn
     */
    @Test
    void nextTurn() {
        game.nextTurn();

        assertEquals(game.currentTurn, Turn.OPPONENT);
    }

    /**
     * Test that <code>nextTurn()<code/> subtract 1 time coin from timePoolLeft
     */
    @Test
    void nextTurnChangeTimePool() {
        int initialTimePool = game.getTimePoolLeft();
        game.nextTurn();
        int timePoolLeft = game.getTimePoolLeft();

        assertTrue(initialTimePool > timePoolLeft);
        assertEquals(timePoolLeft, initialTimePool - 1);
    }
}