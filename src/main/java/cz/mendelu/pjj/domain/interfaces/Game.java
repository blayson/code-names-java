package cz.mendelu.pjj.domain.interfaces;


import cz.mendelu.pjj.domain.ClueLog;
import cz.mendelu.pjj.domain.Turn;

public interface Game {
    public void endGame();

    public int checkAllClueCounters();

    public ClueLog getClueLog(Turn whose);

    public ClueLog getClueLog();

    void nextTurn();
}
