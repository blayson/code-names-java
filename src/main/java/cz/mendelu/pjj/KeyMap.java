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

    Agent getAgent(byte position) {
        throw new UnsupportedOperationException("Does not implemented yet");
    }

    public void generateAgents() {
        int count = 0;
        for (Agent agent : this.agents) {
            count++;
            Agent newAgent = new InnocentAgent(count);
            System.out.println(newAgent.getInformation() + " Agent");
        }
    }

    Agent revealAgent(byte position) {
        throw new UnsupportedOperationException("Does not implemented yet");
    }

    private void setAgent(byte position, Agent agent) {
        this.agents[position] = agent;
    }

    public void setAgents(Agent[] agents) {
        this.agents = agents;
    }
}


