package cz.mendelu.pjj;

import cz.mendelu.pjj.interfaces.Agent;
import cz.mendelu.pjj.interfaces.PlayerInterface;

public class InnocentAgent implements Agent {
    public int count;

    public InnocentAgent() {
    }

    /**
     * V InnocentAgent tato metoda implementuje ukonceni tahu
     */
    @Override
    public void action(PlayerInterface player) {
        throw new UnsupportedOperationException("Does not implemented yet");

    }


    @Override
    public String getInformation() {
        return count + " Innocent bystander";
    }
}
