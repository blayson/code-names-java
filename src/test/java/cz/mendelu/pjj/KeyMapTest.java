package cz.mendelu.pjj;

import cz.mendelu.pjj.interfaces.Agent;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class KeyMapTest {
    /**
     * @author Chuprina
     */
    @Test
    void generate25Agents() {
        //given
        KeyMap keyMap = new KeyMap();
        ArrayList<Agent> agents;
        // when
        keyMap.generateAgents();
        agents = keyMap.getAgentList();
        // then
        assertEquals(25, agents.size());
        assertNotNull(agents.get(0));
        assertNotNull(agents.get(1));
        assertNotNull(agents.get(2));
        assertNotNull(agents.get(24));
    }

    @Test
    void generate9FriendlyAgents() {
        //given
        KeyMap keyMap = new KeyMap();
        ArrayList<Agent> agents;

        // when
        keyMap.generateAgents();
        agents = keyMap.getAgentList();
        // then
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
        //given
        KeyMap keyMap = new KeyMap();
        ArrayList<Agent> agents;
        // when
        keyMap.generateAgents();
        agents = keyMap.getAgentList();
        // then
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
        //given
        KeyMap keyMap = new KeyMap();
        ArrayList<Agent> agents;
        // when
        keyMap.generateAgents();
        agents = keyMap.getAgentList();
        // then
        int count = 0;
        for (Agent agent : agents) {
            if (agent instanceof InnocentAgent) {
                count++;
            }
        }
        assertEquals(13, count);
    }
}