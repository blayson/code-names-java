package cz.mendelu.pjj;

import cz.mendelu.pjj.interfaces.Agent;

public class KeyMap {
    private Agent[] agents;
    public static final int MAX_FRIENDLY = 9;
    public static final int MAX_ENEMY = 3;
    public static final int MAX_BYSTANDER = 13; // change


    public KeyMap() {
        // memory allocation for an agent array
        this.agents = new Agent[25];
    }

    /**
     * Ze vsech agentu vybete toho , ktery se nachazi na zadane pozice
     *
     * @param position - poradi agentu
     * @return vrati agenta, ktery se nachazi na zadane pozice
     */
    public Agent getAgent(int position) {
        return agents[position];
    }

    /**
     * Get all agents that stored in KeyMap object
     * @return array of agents
     */
    public Agent[] getAgents() {
        return agents;
    }

    /**
     * Tato metoda provadi generovani 25 agentu,
     * z nich 9 friendlyAgent, 3 enemy a 13 bystander
     */
    public void generateAgents() {
        for (int i = 0; i < 25; i++) {
            Agent newAgent = new InnocentAgent();
            System.out.println(newAgent.getInformation() + " Agent");
            this.agents[i] = newAgent;
        }
    }

    private void setAgent(byte position, Agent agent) {
        this.agents[position] = agent;
    }

    public void setAgents(Agent[] agents) {
        this.agents = agents;
    }
}


