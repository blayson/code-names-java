package cz.mendelu.pjj;

import cz.mendelu.pjj.interfaces.Agent;
import cz.mendelu.pjj.interfaces.Game;
import cz.mendelu.pjj.interfaces.PlayerInterface;

public class EnemyAgent implements Agent {
    public EnemyAgent() {

    }

    /**
     * V EnemyAgent tato metoda implementuje ukonceni hry
     */
    @Override
    public void action(PlayerInterface player, Game game) {
        throw new UnsupportedOperationException("Does not implemented yet");

    }

    @Override
    public String getInformation() {
        return null;
    }
}
