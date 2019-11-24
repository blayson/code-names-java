package cz.mendelu.pjj;

import cz.mendelu.pjj.interfaces.Agent;
import cz.mendelu.pjj.interfaces.Game;
import cz.mendelu.pjj.interfaces.PlayerInterface;

import java.util.Objects;

public class InnocentAgent implements Agent {
    public InnocentAgent() {

    }

    @Override
    public String toString() {
        return "InnocentAgent{}";
    }
    /**
     * V InnocentAgent tato metoda implementuje ukonceni tahu
     */
    @Override
    public void action(PlayerInterface player, Game game, String word) {
        throw new UnsupportedOperationException("Does not implemented yet");

    }

}
