package cz.mendelu.pjj.domain;

import cz.mendelu.pjj.domain.interfaces.Agent;
import cz.mendelu.pjj.domain.interfaces.Game;
import cz.mendelu.pjj.domain.interfaces.PlayerInterface;

import java.io.Serializable;

public class InnocentAgent implements Agent, Serializable {
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
