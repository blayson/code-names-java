package cz.mendelu.pjj.io;

import cz.mendelu.pjj.domain.Board;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class WordsReader {
    private WordsReader() {}

    /**
     * @author Chuprina
     * @param file json file with words
     * @return new board
     * @version etapa 4
     */
    public static Board read(String file) {
        Board board = new Board();
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(file)) {
            Object obj = jsonParser.parse(reader);
            JSONArray wordsList = (JSONArray) obj;
            board.createWordList(wordsList);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return board;
    }
}
