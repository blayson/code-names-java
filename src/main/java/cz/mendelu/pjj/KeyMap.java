package cz.mendelu.pjj;

import cz.mendelu.pjj.interfaces.Agent;

public class KeyMap {
    private Agent[] agents;
    public static final int MAX_FRIENDLY = 9;
    public static final int MAX_ENEMY = 3;
    public static final int MAX_BYSTANDER = 13; // change


    public KeyMap() {
        this.agents = new Agent[25];
    }

    /**
     * sdfsfdsfsdfs
     * @param position
     * @return
     */
    Agent getAgent(byte position) {
        throw new UnsupportedOperationException("Does not implemented yet");
    }

    /**
     * Tato metoda provadi generovani 25 agentu,
     * z nich 9 friendlyAgent, 3 enemy a 13 bystander
     */
    public void generateAgents() {
        int count = 0;
        for (Agent agent : this.agents) {
            count++;
            Agent newAgent = new InnocentAgent(count);
            System.out.println(newAgent.getInformation() + " Agent");
        }
    }

    /**
     * Ze vsech agentu vybete toho , ktery se nachazi na zadane pozice
     * @param position - poradi agentu
     * @return vrati agenta, ktery se nachazi na zadane pozice
     */
    public Agent revealAgent(byte position) {
        throw new UnsupportedOperationException("Does not implemented yet");
    }

    private void setAgent(byte position, Agent agent) {
        this.agents[position] = agent;
    }

    public void setAgents(Agent[] agents) {
        this.agents = agents;
    }
}


