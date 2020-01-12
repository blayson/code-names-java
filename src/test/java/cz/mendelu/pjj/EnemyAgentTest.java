package cz.mendelu.pjj;

import cz.mendelu.pjj.domain.*;
import cz.mendelu.pjj.domain.interfaces.Agent;
import cz.mendelu.pjj.domain.interfaces.Game;
import cz.mendelu.pjj.domain.interfaces.PlayerInterface;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyAgentTest {
    private static Game game;
    private static TestPlayer testPlayer;
    private static TestPlayer testOpponent;

    /**
     * @author But
     */
    public static class TestPlayer extends Player implements PlayerInterface {
        public String status;

        public TestPlayer(String name) {
            super(name);
        }

        @Override
        public void endGame(Game game) {
            System.out.println("YOU LOSE!");
            this.status = "YOU LOSE!";
        }
    }

    @BeforeAll
    static void setUp() {
        // given
        testPlayer = new TestPlayer("Andrew");
        testOpponent = new TestPlayer("Lena");
        game = new CodeNamesGame(Level.EASY, testPlayer, testOpponent, Turn.PLAYER);
    }

    /**
     * @author But
     */
    @Test
    void action() {
        // given
        Agent enemyAgent = new EnemyAgent();
        // when
        enemyAgent.action(testPlayer, game, "Word");
        // then
        assertEquals("YOU LOSE!", testPlayer.status);

    }
}