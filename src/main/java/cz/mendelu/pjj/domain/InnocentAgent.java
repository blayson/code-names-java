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
     * @return
     */
    @Override
    public Agent action(PlayerInterface player, Game game, String word) {
        player.endTurn(game);
        return this;
    }

}
