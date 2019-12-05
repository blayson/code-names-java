package cz.mendelu.pjj;

import cz.mendelu.pjj.interfaces.Agent;
import cz.mendelu.pjj.interfaces.Game;
import cz.mendelu.pjj.interfaces.PlayerInterface;

import java.util.Objects;

public class FriendlyAgent implements Agent {
    public FriendlyAgent() {

    }

    @Override
    public String toString() {
        return "FriendlyAgent{}";
    }

    /**
     * V FriendlyAgent tato metode kontroluje pokud existuji slova ktery je mozne odhadnout
     * kdyz ano, povoli jeste jednou vybrat slovo
     * kdyz ne, ukonci tah
     *
     * @author But
     *  @version etapa 3
     */
    @Override
    public void action(PlayerInterface player, Game game, String word) {
       int clueCount = game.checkAllClueCounters();
       ClueLog log = game.getClueLog();
       int currentClueCount = log.getWordCounter(word);
       if (clueCount > 0) {
           if (currentClueCount > 0) {
               log.decreaseWordCounter(word);
               player.continueTurn();
           } else {
               player.chooseAnotherWord();
           }
       } else {
           player.endTurn(game);
       }

    }
}
