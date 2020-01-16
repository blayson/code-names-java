package cz.mendelu.pjj.io;

import cz.mendelu.pjj.domain.CodeNamesGame;

import java.io.*;

public class GameLoader {
    private GameLoader() {}

    /**
     * @author But
     * @version etapa 4
     */
    public static CodeNamesGame load() throws IOException, ClassNotFoundException {
        return load(null);
    }

    /**
     * @author But
     * @version etapa 4
     */
    public static CodeNamesGame load(String file) throws IOException, ClassNotFoundException {
        if(file == null) {
            file = "save.ser";
        }

        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        CodeNamesGame savedGame = (CodeNamesGame) objectInputStream.readObject();

        objectInputStream.close();
        return savedGame;
    }
}
