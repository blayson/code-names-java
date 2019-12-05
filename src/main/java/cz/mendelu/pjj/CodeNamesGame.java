package cz.mendelu.pjj;

import cz.mendelu.pjj.interfaces.Game;
import cz.mendelu.pjj.interfaces.PlayerInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CodeNamesGame implements Game {
    private Level level;
    private PlayerInterface player;
    /**
     * @author But
     * @version etapa 3
     */
    private Map<Turn, ClueLog> clueLogs = new HashMap<>();
    public Turn currentTurn;
    private int timePoolLeft;

    public CodeNamesGame(Level level, PlayerInterface player, Turn currentTurn) {
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
     * @return pocet slov, kterych je nutne jeste odhadnout, return 0 jestli vsechni slovesa uz byli odhadnuty
     * @author But
     *  @version etapa 3
     */
    public int checkAllClueCounters(Turn whose) {
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

    public int checkAllClueCounters() {
        return checkAllClueCounters(currentTurn);
    }

    public ClueLog getClueLog(Turn whose) {
        return clueLogs.get(whose);
    }

    public ClueLog getClueLog() {
        return clueLogs.get(currentTurn);
    }

    /**
     * Tato metoda snizuje hodnotu promenne <code>timePoolLeft</code>
     * a meni  tah
     *
     * @author Chuprina
     *  @version etapa 3
     */
    @Override
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

    public PlayerInterface getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    /**
     * @author But
     * @version etapa 3
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CodeNamesGame)) return false;
        CodeNamesGame that = (CodeNamesGame) o;
        return timePoolLeft == that.timePoolLeft &&
                level == that.level &&
                player.equals(that.player) &&
                Objects.equals(clueLogs, that.clueLogs) &&
                currentTurn == that.currentTurn;
    }
    /**
     * @author But
     * @version etapa 3
     */
    @Override
    public int hashCode() {
        return Objects.hash(level, player, clueLogs, currentTurn, timePoolLeft);
    }
    /**
     * @author But
     * @version etapa 3
     */
    @Override
    public String toString() {
        return "CodeNamesGame{" +
                "level=" + level +
                ", player=" + player +
                ", clueLogs=" + clueLogs +
                ", currentTurn=" + currentTurn +
                ", timePoolLeft=" + timePoolLeft +
                '}';
    }
}
