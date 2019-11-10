package cz.mendelu.pjj;

import cz.mendelu.pjj.interfaces.Agent;

public class InnocentAgent implements Agent {
    public int count;
    public InnocentAgent(int count) {
        this.count = count;
    }

    @Override
    public void action() {
        throw new UnsupportedOperationException("Does not implemented yet");

    }

    @Override
    public String getInformation() {
        return count + " Innocent bystander";
    }
}
