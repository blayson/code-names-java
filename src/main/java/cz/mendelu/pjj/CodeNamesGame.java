package cz.mendelu.pjj;

import cz.mendelu.pjj.interfaces.Game;

public class CodeNamesGame implements Game {
    private Level level;
    private Player player;
    private ClueLog[] log;
    public Turn currentTurn;
    private int timePoolLeft;

    public CodeNamesGame(Level level, Player player, ClueLog[] log, Turn currentTurn) {
        this.level = level;
        this.player = player;
        this.log = log;
        this.currentTurn = currentTurn;
        switch (level) {
            case EASY: {
                timePoolLeft = 11;
                break;
            }
            case MEDIUM: {
                timePoolLeft = 10;
                break;
            }
            case HARD: {
                timePoolLeft = 9;
                break;
            }
            default: timePoolLeft = 9;
        }
    }

    public Level getCurrentLevel() {
        throw new UnsupportedOperationException("Does not implemented yet");

    }

    public void endGame() {
        throw new UnsupportedOperationException("Does not implemented yet");
    }

    /**
     * Tato metoda zjisti pokud v ClueLogu jsou jeste slova, kteri je mozne odhadnout
     *
     * @return pocet slov , kterych je nutne jeste odhadnout
     *
     * @author But
     */
    public int checkClueLog() {
        throw new UnsupportedOperationException("Does not implemented yet");
    }

    public void setLog(ClueLog[] log) {
        this.log = log;
    }

    /**
     * Tato metoda snizuje hodnotu promenne <code>timePoolLeft</code>
     * a meni  tah
     *
     *
     * @author Chuprina
     */
    public void nextTurn() {
        currentTurn = currentTurn.toNext();
        timePoolLeft--;
    }

    public int getTimePoolLeft() {
        return timePoolLeft;
    }

    public void setTimePool(int timePool) {
        this.timePoolLeft = timePool;
    }
}
