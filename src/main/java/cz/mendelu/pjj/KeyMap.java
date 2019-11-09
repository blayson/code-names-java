package cz.mendelu.pjj;

public class KeyMap {
    Agent[] agents;
    public static final int MAX_FRIENDLY = 9;
    public static final int MAX_ENEMY= 3;
    public static final int MAX_BYSTANDER= 15; // zmenit


    public KeyMap(Agent[] agents) {
        this.agents = agents;
    }
    Agent getAgent(byte position){
        throw new UnsupportedOperationException("Does not implemented yet");
    }
    public void createAgents(){
        throw new UnsupportedOperationException("Does not implemented yet");

    }
    Agent revealAgent(byte position){
        throw new UnsupportedOperationException("Does not implemented yet");
    }
    private void setAgent(byte position, Agent agent){

        this.agents[position]=agent;

    }
}


