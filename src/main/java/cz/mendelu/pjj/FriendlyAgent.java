package cz.mendelu.pjj;

import cz.mendelu.pjj.interfaces.Agent;

public class FriendlyAgent implements Agent {

    public FriendlyAgent() {

    }
    /**
     * V FriendlyAgent tato metode kontroluje pokud existuji slova ktery je mozne odhadnout
     * kdyz ano, povoli jeste jednou vybrat slovo
     * kdyz ne, ukonci tah
     */
    @Override
    public void action() {
        throw new UnsupportedOperationException("Does not implemented yet");

    }

    @Override
    public String getInformation() {
        return null;
    }
}
