package cz.mendelu.pjj;

import cz.mendelu.pjj.interfaces.Agent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class KeyMap {
    ArrayList<Agent> agentList;
    //  private Agent[] agents;
    public static final int MAX_FRIENDLY = 9;
    public static final int MAX_ENEMY = 3;
    public static final int MAX_BYSTANDER = 13; // change


    public KeyMap() {
        // memory allocation for an agent array
        agentList = new ArrayList<>(25);

    }

    /**
     * Ze vsech agentu vybete toho , ktery se nachazi na zadane pozice
     *
     * @param position - poradi agentu
     * @return vrati agenta, ktery se nachazi na zadane pozice
     */
    public Agent getAgent(int position) {
        return agentList.get(position);
    }

    /**
     * Get all agents that stored in KeyMap object
     *
     * @return array of agents
     */
    public ArrayList<Agent> getAgentList() {
        return agentList;
    }

    /**
     * Tato metoda provadi generovani 25 agentu,
     * z nich 9 friendlyAgent, 3 enemy a 13 bystander
     *
     * @author Chuprina
     */
    public void generateAgents() {
        agentList = generateFriendlyAgents();
        agentList.addAll(generateEnemyAgents());
        agentList.addAll(generateInnocentAgents());
        shuffleAgents();
        for (int i = 0; i < agentList.size(); i++) {
            Agent newAgent = getAgent(i);
            System.out.println(newAgent.getInformation() + " Agent");
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

    public ArrayList<Agent> generateFriendlyAgents() {
        ArrayList<Agent> friendlyAgentList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            Agent newAgent = new FriendlyAgent();
            friendlyAgentList.add(i, newAgent);
        }
        return friendlyAgentList;
    }

    public ArrayList<Agent> generateEnemyAgents() {
        ArrayList<Agent> enemyAgentList = new ArrayList<Agent>();
        for (int i = 0; i < 3; i++) {
            Agent newAgent = new EnemyAgent();
            enemyAgentList.add(i, newAgent);
        }
        return enemyAgentList;
    }

    public ArrayList<Agent> generateInnocentAgents() {
        ArrayList<Agent> innocentAgentList = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            Agent newAgent = new InnocentAgent();
            innocentAgentList.add(i, newAgent);
        }
        return innocentAgentList;
    }

    private void setAgent(byte position, Agent agent) {
        agentList.add(position, agent);
    }

    public void setAgentList(ArrayList<Agent> agentList) {
        this.agentList = agentList;
    }
}


