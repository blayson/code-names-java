package cz.mendelu.pjj;

import cz.mendelu.pjj.interfaces.Agent;
import cz.mendelu.pjj.interfaces.Game;
import cz.mendelu.pjj.interfaces.PlayerInterface;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyAgentTest {
    private static Game game;

    public static class TestPlayer implements PlayerInterface {
        public String status;

        @Override
        public boolean checkWord(byte position) {
            return false;
        }

        public void endGame(CodeNamesGame game) {
            System.out.println("YOU LOSE!");
            this.status = "YOU LOSE!";
        }
    }

    @Test
    void action() {
        Agent enemyAgent = new EnemyAgent();

        TestPlayer testPlayer = new TestPlayer();
        enemyAgent.action(testPlayer, game);

        assertEquals("YOU LOSE!", testPlayer.status);

    }
}