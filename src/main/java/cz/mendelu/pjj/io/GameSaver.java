package cz.mendelu.pjj.io;

import cz.mendelu.pjj.domain.CodeNamesGame;

import java.io.*;

public class GameSaver {
    private GameSaver() {}

    /**
     * @author But
     * @version etapa 4
     */
    public static void save(String fileName, CodeNamesGame game) throws IOException {
        saveObject(fileName, game);
    }

    /**
     * @author But
     * @version etapa 4
     */
    public static void save(CodeNamesGame game) throws IOException {
        saveObject("save.ser", game);
    }

    /**
     * @author But
     * @version etapa 4
     */
    private static void saveObject(String fileName, CodeNamesGame game) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(game);
        objectOutputStream.close();
    }
}
