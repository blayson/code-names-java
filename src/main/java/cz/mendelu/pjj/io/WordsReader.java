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
     * @return words list
     * @version etapa 4
     */
    public static JSONArray read(String file) {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(file)) {
            Object obj = jsonParser.parse(reader);
            return (JSONArray) obj;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @author Chuprina
     * @return words list
     * @version etapa 4
     */
    public static JSONArray read() {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("words.json")) {
            Object obj = jsonParser.parse(reader);
            return (JSONArray) obj;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
