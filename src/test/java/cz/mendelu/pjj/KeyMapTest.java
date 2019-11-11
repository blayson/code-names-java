package cz.mendelu.pjj;

import cz.mendelu.pjj.interfaces.Agent;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KeyMapTest {
    private static KeyMap keyMap;

    @BeforeAll
    static void setUp() {
        // given
        keyMap = new KeyMap();
    }

    @Test
    void generate25Agents() {
        // when
        keyMap.generateAgents();
        Agent[] agents = keyMap.getAgents();
        // then
        assertEquals(25, agents.length);
        assertNotNull(agents[0]);
        assertNotNull(agents[1]);
        assertNotNull(agents[2]);
        assertNotNull(agents[24]);
    }

    @Test
    void generate9FriendlyAgents() {
        // when
        keyMap.generateAgents();
        Agent[] agents = keyMap.getAgents();
        int count = 0;
        for (Agent agent : agents) {
            if (agent instanceof FriendlyAgent) {
                count++;
            }
        }
        // then
        assertEquals(9, count);
    }

    @Test
    void generate3EnemyAgents() {
        // when
        keyMap.generateAgents();
        Agent[] agents = keyMap.getAgents();
        int count = 0;
        for (Agent agent : agents) {
            if (agent instanceof EnemyAgent) {
                count++;
            }
        }
        // then
        assertEquals(3, count);
    }

    @Test
    void generate13InnocentAgents() {
        // when
        keyMap.generateAgents();
        Agent[] agents = keyMap.getAgents();
        int count = 0;
        for (Agent agent : agents) {
            if (agent instanceof InnocentAgent) {
                count++;
            }
        }
        // then
        assertEquals(13, count);
    }
}