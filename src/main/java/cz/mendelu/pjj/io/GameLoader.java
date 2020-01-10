package cz.mendelu.pjj.io;

import cz.mendelu.pjj.domain.CodeNamesGame;

import java.io.*;

public class GameLoader {
    private GameLoader() {}

    /**
     * @author But
     * @version etapa 4
     */
    public static CodeNamesGame load(String file) throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream("save.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        CodeNamesGame savedGame = (CodeNamesGame) objectInputStream.readObject();

        System.out.println(savedGame);

        objectInputStream.close();
        return savedGame;
    }
}
