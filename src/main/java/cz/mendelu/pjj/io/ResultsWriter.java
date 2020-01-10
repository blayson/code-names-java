package cz.mendelu.pjj.io;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ResultsWriter {
    private ResultsWriter() {}

    /**
     * @author Chuprina
     * @version etapa 4
     */
    public static void write(String file, String results) {
        try (FileWriter writer = new FileWriter(file)) {
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(results);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
