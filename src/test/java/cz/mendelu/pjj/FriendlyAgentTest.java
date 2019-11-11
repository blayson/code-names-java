package cz.mendelu.pjj;

import cz.mendelu.pjj.interfaces.Game;
import cz.mendelu.pjj.interfaces.PlayerInterface;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FriendlyAgentTest {
    private static TestCodeNamesGame game;
    private static FriendlyAgent friendlyAgent;
    private static TestPlayer player;

    public static class TestWord {
        private String value;
        private boolean check;

        TestWord(String value, boolean check) {
            this.value = value;
            this.check = check;

        }

        Boolean isChecked() {
            return check;
        }

        public String getValue() {
            return value;
        }
    }

    public static class TestPlayer implements PlayerInterface {
        public KeyMap keyMap;
        TestWord[] words;

        TestPlayer() {
            this.words = new TestWord[25];

        }

        void setWords(boolean check) {
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
        Turn currentTurn;
        protected ClueLog[] log;

        TestCodeNamesGame(Turn currentTurn) {
            this.currentTurn = currentTurn;
        }

        public int checkClueLog() {
            return 0;
        }
    }

    public static class TestCodeNamesGame2 extends TestCodeNamesGame implements Game {
        TestCodeNamesGame2(Turn currentTurn) {
            super(currentTurn);
        }

        public int checkClueLog() {
            return 1;
        }
    }

    /**
     * Initial setup for testing
     */
    @BeforeAll
    static void setUp() {
        // given
        friendlyAgent = new FriendlyAgent();
        player = new TestPlayer();
        player.setWords(false);
    }

    /**
     * Test <code>action()</code> method that <b>changes turn</b> if player doesn't have any possibilities to act
     */
    @Test
    void actionToChangeTurn() {
        // given
        game = new TestCodeNamesGame(Turn.PLAYER);
        if (game.currentTurn == Turn.PLAYER) {
            // when
            friendlyAgent.action(player, game);
            // then
            assertSame(game.currentTurn, Turn.OPPONENT);
        } else {
            // when
            friendlyAgent.action(player, game);
            // then
            assertSame(game.currentTurn, Turn.PLAYER);
        }

    }

    /**
     * Test <code>action()</code> method that <b>doesn't change turn</b> if player has some possibilities to act
     */
    @Test
    void actionNotToChangeTurn() {
        // given
        game = new TestCodeNamesGame2(Turn.PLAYER);
        if (game.currentTurn == Turn.PLAYER) {
            // when
            friendlyAgent.action(player, game);
            // then
            assertSame(game.currentTurn, Turn.PLAYER);
        } else {
            // when
            friendlyAgent.action(player, game);
            // then
            assertSame(game.currentTurn, Turn.OPPONENT);
        }

    }
}