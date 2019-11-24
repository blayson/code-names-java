package cz.mendelu.pjj;

import cz.mendelu.pjj.interfaces.Game;

import java.util.HashMap;
import java.util.Map;

public class CodeNamesGame implements Game {
    private Level level;
    private Player player;
    private Map<Turn, ClueLog> clueLogs = new HashMap<>();
    public Turn currentTurn;
    private int timePoolLeft;

    public CodeNamesGame(Level level, Player player, Turn currentTurn) {
        this.level = level;
        this.player = player;
        this.currentTurn = currentTurn;
        clueLogs.put(Turn.PLAYER, new ClueLog());
        clueLogs.put(Turn.OPPONENT, new ClueLog());

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
            default:
                timePoolLeft = 9;
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
     * @param whose typ hrace aby vedet jaky log musime vzit
     * @return pocet slov , kterych je nutne jeste odhadnout, return 0 jestli vsechni slovesa uz byli odhadnuty
     * @author But
     */
    public int checkClueLog(Turn whose) {
        ClueLog log = clueLogs.get(whose);
        if (log.isDone()) {
            return 0;
        }

        Integer count = 0;
        for (Map.Entry<String, Integer> clue : log.getWordList().entrySet()) {
            Integer wordClueCount = clue.getValue();
            if (wordClueCount >= 0) {
                count = count + wordClueCount;
            }
        }
        return count;
    }

    public int checkClueLog() {
        ClueLog log = clueLogs.get(currentTurn);
        return 0;
    }

    public ClueLog getClueLog(Turn whose) {
        return clueLogs.get(whose); // ochrani mnozinu proti modifikaci, nikdo krome me nemuze sem zapisovat
        // zajistime , ze k mnozine se prida jenom pomoci metody addLogs, nesmi se prida pomoci primeho pridavani do mmoziny .add
    }

    /**
     * Tato metoda snizuje hodnotu promenne <code>timePoolLeft</code>
     * a meni  tah
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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
