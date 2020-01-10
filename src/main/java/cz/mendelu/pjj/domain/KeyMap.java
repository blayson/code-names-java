package cz.mendelu.pjj.domain;

import cz.mendelu.pjj.domain.interfaces.Agent;

import java.io.Serializable;
import java.util.*;

public class KeyMap implements Serializable {
    /**
     * @author Chuprina
     * @version etapa 3
     */
    private List<Agent> agentList = new ArrayList<>(25);

    public KeyMap() {
        // memory allocation for an agent array
//        agentList = new ArrayList<>(25);

    }

    /**
     * Ze vsech agentu vybete toho , ktery se nachazi na zadane pozice
     * @param position - poradi agentu
     * @return vrati agenta, ktery se nachazi na zadane pozice
     */
    public Agent getAgent(int position) {
        return agentList.get(position);
    }

    /**
     *
     * Get all agents that stored in KeyMap object
     *
     * @return array of agents
     */
    public List<Agent> getAgentList() {
        return agentList;
    }

    /**
     * Tato metoda provadi generovani 25 agentu,
     * z nich 9 friendlyAgent, 3 enemy a 13 bystander
     *
     * @author Chuprina
     * @version etapa 3
     */

    public void generateAgents() {
        agentList = generateFriendlyAgents();
        agentList.addAll(generateEnemyAgents());
        agentList.addAll(generateInnocentAgents());
        shuffleAgents();
        for (int i = 0; i < agentList.size(); i++) {
            Agent newAgent = getAgent(i);
            System.out.println(newAgent.toString() + " Agent");
        }
    }

    /**
     * Tato metoda rozmisti generovani 25 agentu,
     *
     * @author Chuprina
     */
    public void shuffleAgents() {
        Collections.shuffle(agentList, new Random());
    }

    public List<Agent> generateFriendlyAgents() {
        List<Agent> friendlyAgentList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            Agent newAgent = new FriendlyAgent();
            friendlyAgentList.add(i, newAgent);
        }
        return friendlyAgentList;
    }

    public List<Agent> generateEnemyAgents() {
      List<Agent> enemyAgentList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Agent newAgent = new EnemyAgent();
            enemyAgentList.add(i, newAgent);
        }
        return enemyAgentList;
    }

    public List<Agent> generateInnocentAgents() {
        List<Agent> innocentAgentList = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            Agent newAgent = new InnocentAgent();
            innocentAgentList.add(i, newAgent);
        }
        return innocentAgentList;
    }

    private void setAgent(byte position, Agent agent) {
        agentList.add(position, agent);
    }



    public void setAgentList(List<Agent> agentList) {
        this.agentList = agentList;
    }

}


