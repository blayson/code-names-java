package cz.mendelu.pjj;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodeNamesGameTest {
    //private static CodeNamesGame game;

    /**
     * Test checkClue() method when all cards wasn't guessed
     *
     * @author But
     */
    /*
    @Test
    void checkClueLogDoesNotHasTries() {
        // given
        CodeNamesGame game;
        game = new CodeNamesGame(Level.HARD, new Player("Andrew"),  Turn.PLAYER);
        ClueLog[] newClueLog = new ClueLog[2];
        newClueLog[0] = new ClueLog("apple", 1);
        newClueLog[1] = new ClueLog("pencil", 2);
        game.setLog(newClueLog);

        int result = game.checkClueLog();

        assertEquals(3, result);
    }

    /**
     * Test <code>checkClue()<code/> method when all cards was guessed
     *
     * @author But
     */
  /*  @Test
    void checkClueLogHasTries() {
        // given
        CodeNamesGame game;
        game = new CodeNamesGame(Level.HARD, new Player("Andrew"),  Turn.PLAYER);
        ClueLog[] newClueLog = new ClueLog[1];
        newClueLog[0] = new ClueLog("apple", 1);
        newClueLog[0].setNumbersLeft(0);
        game.setLog(newClueLog);

        int result = game.checkClueLog();

        assertEquals(0, result);
    }

    /**
     * Test if <code>nextTurn()<code/> switch game turn
     *
     * @author Chuprina
     */



    @Test
    void nextTurn() {
        // given
        CodeNamesGame game = new CodeNamesGame(Level.HARD, new Player("Andrew"),  Turn.PLAYER);
        // when
        game.nextTurn();
        // then
        assertEquals(game.currentTurn, Turn.OPPONENT);
    }

    /**
     * Test that <code>nextTurn()<code/> subtract 1 time coin from timePoolLeft
     *
     * @author Chuprina
     */
    @Test
    void nextTurnChangeTimePool() {
        // given
        CodeNamesGame game;
        game = new CodeNamesGame(Level.HARD, new Player("Andrew"), Turn.PLAYER);
        //when
        int initialTimePool = game.getTimePoolLeft();
        game.nextTurn();
        int timePoolLeft = game.getTimePoolLeft();
        //then
        assertTrue(initialTimePool > timePoolLeft);
        assertEquals(timePoolLeft, initialTimePool - 1);
    }
}