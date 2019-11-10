package cz.mendelu.pjj;

import cz.mendelu.pjj.interfaces.Agent;
import cz.mendelu.pjj.interfaces.PlayerInterface;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class FriendlyAgentTest {
    static TestCodeNamesGame game;

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

    public static class TestCodeNamesGame {
        public Turn currentTurn;

        public TestCodeNamesGame(Turn currentTurn) {
            this.currentTurn = currentTurn;
        }
    }

    @BeforeAll
    static void setUp(){
        game = new TestCodeNamesGame(Turn.PLAYER);
    }

    @Test
    void action() {
        Agent friendlyAgent = new FriendlyAgent();
        PlayerInterface player = new TestPlayer();
        ((TestPlayer) player).setWords(false);
        friendlyAgent.action(player);

    }
}