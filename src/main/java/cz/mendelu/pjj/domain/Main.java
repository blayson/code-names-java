package cz.mendelu.pjj.domain;

import cz.mendelu.pjj.io.GameLoader;
import cz.mendelu.pjj.io.GameSaver;
import cz.mendelu.pjj.io.WordsReader;

import java.io.IOException;
import java.util.List;

/**
 * @author Andrii But
 * @author Olena Chuprina
 */
public class Main {
    public static void main(String[] args) {
//        KeyMap keyMap = new KeyMap();
//        keyMap.generateAgents();
        Player player = new Player("Andrew");
        Player opponent = new Player("Lena");
        CodeNamesGame game = new CodeNamesGame(Level.HARD, player, opponent, Turn.PLAYER);
        try {
            GameSaver.save(game);
            System.out.println(game.getPlayer().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            CodeNamesGame loadedGame = GameLoader.load("save.ser");
            System.out.println(loadedGame.getOpponent().toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
//        Board board = WordsReader.read("words.json");
//        List<Word> wl = board.getWordList();
//        System.out.println(wl);
    }
}
