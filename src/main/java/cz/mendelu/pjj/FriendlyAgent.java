package cz.mendelu.pjj;

import cz.mendelu.pjj.interfaces.Agent;
import cz.mendelu.pjj.interfaces.Game;
import cz.mendelu.pjj.interfaces.PlayerInterface;

public class FriendlyAgent implements Agent {
    int count;

    public FriendlyAgent() {

    }

    /**
     * V FriendlyAgent tato metode kontroluje pokud existuji slova ktery je mozne odhadnout
     * kdyz ano, povoli jeste jednou vybrat slovo
     * kdyz ne, ukonci tah
     */
    @Override
    public void action(PlayerInterface player, Game game) {
        throw new UnsupportedOperationException("Does not implemented yet");

    }

    @Override
    public String getInformation() {
        return count + " Friendly bystander";
    }
}
