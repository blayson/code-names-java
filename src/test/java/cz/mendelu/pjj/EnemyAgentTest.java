package cz.mendelu.pjj;

import cz.mendelu.pjj.interfaces.Agent;
import cz.mendelu.pjj.interfaces.PlayerInterface;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyAgentTest {

    public static class TestPlayer implements PlayerInterface  {
        public String status;
        @Override
        public boolean checkWord(byte position) {
            return false;
        }

        public void endGame(CodeNamesGame game) {
            System.out.println("YOU LOSE!");
            this.status = "EXIT";
        }
    }
    @Test
    void action() {
        Agent enemyAgent = new EnemyAgent();

        TestPlayer testPlayer = new TestPlayer();
        enemyAgent.action(testPlayer);

        assertEquals("EXIT", testPlayer.status);

    }
}