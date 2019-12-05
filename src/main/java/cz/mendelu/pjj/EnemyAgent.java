package cz.mendelu.pjj;

import cz.mendelu.pjj.interfaces.Agent;
import cz.mendelu.pjj.interfaces.Game;
import cz.mendelu.pjj.interfaces.PlayerInterface;

import java.util.Objects;

public class EnemyAgent implements Agent {
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
     *  @version etapa 3
     */
    @Override
    public void action(PlayerInterface player, Game game, String word) {
        player.endGame(game);
    }

}
