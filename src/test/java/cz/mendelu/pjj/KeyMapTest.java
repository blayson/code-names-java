package cz.mendelu.pjj;

import cz.mendelu.pjj.interfaces.Agent;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KeyMapTest {
    private static Agent[] agents;

    @BeforeAll
    static void setUp() {
        KeyMap keyMap = new KeyMap();
        keyMap.generateAgents();
        agents = keyMap.getAgents();
    }

    @Test
    void generate25Agents() {
        assertEquals(25, agents.length);
        assertNotNull(agents[0]);
        assertNotNull(agents[1]);
        assertNotNull(agents[2]);
        assertNotNull(agents[24]);
    }

    @Test
    void generate9FriendlyAgents() {
        int count = 0;
        for (Agent agent : agents) {
            if (agent instanceof FriendlyAgent) {
                count++;
            }
        }

        assertEquals(9, count);
    }

    @Test
    void generate3EnemyAgents() {
        int count = 0;
        for (Agent agent : agents) {
            if (agent instanceof EnemyAgent) {
                count++;
            }
        }

        assertEquals(3, count);
    }

    @Test
    void generate13InnocentAgents() {
        int count = 0;
        for (Agent agent : agents) {
            if (agent instanceof InnocentAgent) {
                count++;
            }
        }

        assertEquals(13, count);
    }
}