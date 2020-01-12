package cz.mendelu.pjj.domain;

import cz.mendelu.pjj.domain.interfaces.Agent;
import cz.mendelu.pjj.domain.interfaces.Game;
import cz.mendelu.pjj.domain.interfaces.PlayerInterface;

import java.io.Serializable;

public class FriendlyAgent implements Agent, Serializable {
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
     * @return this
     */
    @Override
    public Agent action(PlayerInterface player, Game game, String word) {
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
        return this;
    }
}
