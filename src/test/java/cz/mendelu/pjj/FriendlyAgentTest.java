package cz.mendelu.pjj;

import cz.mendelu.pjj.interfaces.PlayerInterface;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class FriendlyAgentTest {
    private static CodeNamesGame game;
    private static FriendlyAgent friendlyAgent;
    private static PlayerInterface player;

    /**
     * Initial setup for testing
     *
     * @author But
     */
    @BeforeAll
    static void setUp() {
        // given
        player = new Player("Andrew");
        game = new CodeNamesGame(Level.HARD, player, Turn.PLAYER);
    }

    /**
     * Test <code>action()</code> method that <b>changes turn</b> if player doesn't have any possibilities to act
     *
     * @author But
     */
    @Test
    void actionToChangeTurn() {
        // given
        friendlyAgent = new FriendlyAgent();
        game.getClueLog().addWord("Word", 1);
        game.getClueLog().decreaseWordCounter("Word");
        if (game.currentTurn == Turn.PLAYER) {
            // when
            friendlyAgent.action(player, game, "Word");
            // then
            assertEquals(Turn.OPPONENT, game.currentTurn);
        } else {
            // when
            friendlyAgent.action(player, game, "Word");
            // then
            assertSame(game.currentTurn, Turn.PLAYER);
        }

    }

    /**
     * Test <code>action()</code> method that <b>doesn't change turn</b> if player has some possibilities to act
     *
     * @author But
     */
    @Test
    void actionNotToChangeTurn() {
        // given
        friendlyAgent = new FriendlyAgent();
        game.getClueLog().addWord("Name", 1);
        if (game.currentTurn == Turn.PLAYER) {
            // when
            friendlyAgent.action(player, game, "Name");
            // then
            assertSame(game.currentTurn, Turn.PLAYER);
        } else {
            // when
            friendlyAgent.action(player, game, "Name");
            // then
            assertSame(game.currentTurn, Turn.OPPONENT);
        }

    }
}