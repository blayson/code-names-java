package cz.mendelu.pjj;

import cz.mendelu.pjj.interfaces.Game;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CodeNamesGame implements Game {
    private Level level;
    private Player player;
    private Set<ClueLog> clueLogs = new HashSet();
    private final int countLog=2;
    public Turn currentTurn;
    private int timePoolLeft;

    public CodeNamesGame(Level level, Player player,  Turn currentTurn) {
        this.level = level;
        this.player = player;
      //  this.log = log;
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
        return level;

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
    public void addLogs() { // prida
        while (countLog >= clueLogs.size()) {
            clueLogs.add(new ClueLog());
        }
    }
    public int checkClueLog() {

        throw new UnsupportedOperationException("Does not implemented yet");
    }

    public void setLog( Set<ClueLog> log) {
        this.clueLogs = log;
    }
    public Collection<ClueLog> getClueLog(){
        return Collections.unmodifiableSet(clueLogs); // ochrani mnozinu proti modifikaci, nikdo krome me nemuze sem zapisovat
        // zajistime , ze k mnozine se prida jenom pomoci metody addLogs, nesmi se prida pomoci primeho pridavani do mmoziny .add
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
