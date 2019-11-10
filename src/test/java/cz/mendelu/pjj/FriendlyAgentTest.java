package cz.mendelu.pjj;

import cz.mendelu.pjj.interfaces.Agent;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FriendlyAgentTest {
    public static class TestKeyMap {

    }

    public static class TestPlayer {
        public KeyMap keyMap;

        public TestPlayer() {

        }

        public boolean checkWord(byte position) {
            return false;
        }
    }

    @Test
    void action() {
        Agent friendlyAgent = new FriendlyAgent();
        friendlyAgent.action();
        assertEquals();
    }
}