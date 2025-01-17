package cz.mendelu.pjj.domain;

import cz.mendelu.pjj.domain.interfaces.Game;
import cz.mendelu.pjj.domain.interfaces.PlayerInterface;
import cz.mendelu.pjj.io.WordsReader;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CodeNamesGame implements Game, Serializable {
    private Level level;
    private PlayerInterface player;
    private PlayerInterface opponent;
    /**
     * @author But
     * @version etapa 3
     */
    private Map<Turn, ClueLog> clueLogs = new HashMap<>();
    public Turn currentTurn;
    private int timePoolLeft;
    private Board board;
    public final String version = "0.0.1a";

    public CodeNamesGame(Level level, PlayerInterface player, PlayerInterface opponent, Turn currentTurn) {
        this.level = level;
        this.player = player;
        this.opponent = opponent;
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

    public static CodeNamesGame getDefaultGame() {
        Player player = new Player("Player 1");
        KeyMap keyMap1 = new KeyMap();
        keyMap1.generateAgents();
        player.setKeyMap(keyMap1);

        Player opponent = new Player("Player 2");
        KeyMap keyMap2 = new KeyMap();
        keyMap2.generateAgents();
        opponent.setKeyMap(keyMap2);

        CodeNamesGame game = new CodeNamesGame(Level.HARD, player, opponent, Turn.PLAYER);

        Board board = Board.getDefaultBoard(WordsReader.read()) ;
        game.setBoard(board);

        return game;
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
     * @version etapa 3
     */
    public int checkAllClueCounters(Turn whose) {
        ClueLog log = clueLogs.get(whose);
        if (log.isDone()) {
            return 0;
        }

        int count = 0;
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

    public void setClue(String word, Integer number) {
        clueLogs.get(currentTurn).addWord(word, number);

    }

    /**
     * Tato metoda snizuje hodnotu promenne <code>timePoolLeft</code>
     * a meni  tah
     *
     * @author Chuprina
     * @version etapa 3
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

    public PlayerInterface getOpponent() {
        return opponent;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public PlayerInterface getCurrentPlayer() {
        if (currentTurn == Turn.PLAYER) {
            return player;
        } else {
            return opponent;
        }
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
                ", opponent=" + opponent +
                ", clueLogs=" + clueLogs +
                ", currentTurn=" + currentTurn +
                ", timePoolLeft=" + timePoolLeft +
                ", version='" + version + '\'' +
                '}';
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Word> getWordCards() {
        return board.getWordList();
    }
}
