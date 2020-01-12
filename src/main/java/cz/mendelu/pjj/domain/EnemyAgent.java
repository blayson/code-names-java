package cz.mendelu.pjj.domain;

import cz.mendelu.pjj.domain.interfaces.Agent;
import cz.mendelu.pjj.domain.interfaces.Game;
import cz.mendelu.pjj.domain.interfaces.PlayerInterface;

import java.io.Serializable;

public class EnemyAgent implements Agent, Serializable {
    public EnemyAgent() {

    }

    @Override
    public String toString() {
        return "EnemyAgent{}";
    }

    /**
     * V EnemyAgent tato metoda implementuje ukonceni hry
     *
     * @author But
     * @version etapa 3
     * @return
     */
    @Override
    public Agent action(PlayerInterface player, Game game, String word) {
        player.endGame(game);
        return this;
    }

}
