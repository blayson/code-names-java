package cz.mendelu.pjj;

import cz.mendelu.pjj.interfaces.Agent;
import cz.mendelu.pjj.interfaces.Game;
import cz.mendelu.pjj.interfaces.PlayerInterface;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyAgentTest {
    private static Game game;
    private static TestPlayer testPlayer;

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
        game = new CodeNamesGame(Level.EASY, testPlayer, Turn.PLAYER);
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