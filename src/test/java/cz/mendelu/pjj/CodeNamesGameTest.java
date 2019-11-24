package cz.mendelu.pjj;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodeNamesGameTest {
    //private static CodeNamesGame game;

    /**
     * Test <code>checkAllClueCountersTries()<code/> method when all cards wasn't guessed
     *
     * @author But
     */
    @Test
    void checkAllClueCountersHasTries() {
        // given
        CodeNamesGame game;
        game = new CodeNamesGame(Level.HARD, new Player("Andrew"),  Turn.PLAYER);
        ClueLog log = game.getClueLog(Turn.PLAYER);
        log.addWord("Fruit", 2);
        log.addWord("Electronics", 1);
        int result = game.checkAllClueCounters(Turn.PLAYER);

        assertEquals(3, result);
    }

    /**
     * Test <code>checkAllClueCountersTries()<code/> method when all cards was guessed
     *
     * @author But
     */
    @Test
    void checkAllClueCountersHasNotTries() {
        // given
        CodeNamesGame game;
        game = new CodeNamesGame(Level.HARD, new Player("Andrew"),  Turn.PLAYER);
        ClueLog log = game.getClueLog(Turn.PLAYER);
        log.addWord("Fruit", 2);
        log.addWord("Electronics", 1);
        log.decreaseWordCounter("Fruit");
        log.decreaseWordCounter("Fruit");
        log.decreaseWordCounter("Electronics");
        int result = game.checkAllClueCounters(Turn.PLAYER);

        assertEquals(0, result);
    }

    /**
     * Test <code>checkAllClueCountersTries()<code/> method when some cards was guessed
     *
     * @author But
     */
    @Test
    void checkAllClueCountersTries() {
        // given
        CodeNamesGame game;
        game = new CodeNamesGame(Level.HARD, new Player("Andrew"),  Turn.PLAYER);
        ClueLog log = game.getClueLog(Turn.PLAYER);
        log.addWord("Fruit", 2);
        log.addWord("Electronics", 1);
        log.decreaseWordCounter("Fruit");
        log.decreaseWordCounter("Fruit");
        int result = game.checkAllClueCounters(Turn.PLAYER);

        assertEquals(1, result);
    }

    /**
     * Test <code>checkAllClueCountersTries()<code/> method for opponent
     *
     * @author But
     */
    @Test
    void checkAllClueCountersTriesForOpponent() {
        // given
        CodeNamesGame game;
        game = new CodeNamesGame(Level.HARD, new Player("Andrew"),  Turn.PLAYER);
        ClueLog log = game.getClueLog(Turn.PLAYER);
        log.addWord("Fruit", 2);
        log.addWord("Electronics", 1);
        log.decreaseWordCounter("Fruit");
        int result = game.checkAllClueCounters(Turn.OPPONENT);

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