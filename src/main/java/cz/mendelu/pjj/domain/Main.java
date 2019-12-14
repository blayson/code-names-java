package cz.mendelu.pjj.domain;

import cz.mendelu.pjj.io.WordsReader;

import java.util.List;

/**
 * @author Andrii But
 * @author Olena Chuprina
 */
public class Main {
    public static void main(String[] args) {
//        KeyMap keyMap = new KeyMap();
//        keyMap.generateAgents();
        Board board = WordsReader.read("words.json");
        List<Word> wl = board.getWordList();
        System.out.println(wl);
    }
}
