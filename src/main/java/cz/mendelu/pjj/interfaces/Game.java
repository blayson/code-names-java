package cz.mendelu.pjj.interfaces;


import cz.mendelu.pjj.ClueLog;
import cz.mendelu.pjj.Turn;

public interface Game {
    public void endGame();

    public int checkAllClueCounters();

    public ClueLog getClueLog(Turn whose);

    public ClueLog getClueLog();

    void nextTurn();
}
