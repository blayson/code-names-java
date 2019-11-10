package cz.mendelu.pjj;

import cz.mendelu.pjj.interfaces.Agent;
import cz.mendelu.pjj.interfaces.Game;
import cz.mendelu.pjj.interfaces.PlayerInterface;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class FriendlyAgentTest {
    private static TestCodeNamesGame game;

    public static class TestKeyMap {

    }

    public static class TestWord {
        private String value;
        private boolean check;

        TestWord(String value, boolean check) {
            this.value = value;
            this.check = check;

        }

        public Boolean isChecked(){
            return check;
        }

        public String getValue() {
            return value;
        }
    }

    public static class TestPlayer implements PlayerInterface {
        public KeyMap keyMap;
        TestWord words[];

        public TestPlayer() {
            this.words = new TestWord[25];

        }
        public void setWords(boolean check) {
            TestWord word = new TestWord("Apple", check);
            Arrays.fill(this.words, word);
        }

        @Override
        public boolean checkWord(byte position) {
            return words[position].isChecked();
        }

        @Override
        public void endGame(CodeNamesGame game) {

        }
    }

    public static class TestCodeNamesGame implements Game {
        public Turn currentTurn;
        ClueLog[] log;

        public TestCodeNamesGame(Turn currentTurn) {
            this.currentTurn = currentTurn;
        }

        public int checkClueLog() {
            return 0;
        }
    }

    @BeforeAll
    static void setUp(){
        game = new TestCodeNamesGame(Turn.PLAYER);
    }

    @Test
    void action() {
        Agent friendlyAgent = new FriendlyAgent();
        TestPlayer player = new TestPlayer();
        player.setWords(false);

        if(game.currentTurn == Turn.PLAYER) {
            friendlyAgent.action(player, game);
            assertSame(game.currentTurn, Turn.OPPONENT);
        } else {
            friendlyAgent.action(player, game);
            assertSame(game.currentTurn, Turn.PLAYER);
        }

    }
}