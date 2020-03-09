package homeworks.hw7;

import java.io.FileWriter;

import lombok.SneakyThrows;

public class FileWriterTextGenerator {

    @SneakyThrows
    public static void generateText(String fileName) {
        FileWriter fileWriter = new FileWriter(fileName);
        for(int i = 0; i < 1500; i++) {
            fileWriter.write("Generating lotsa text which is not random" +
                    "because we are very lazy");
        }
        fileWriter.flush();
    }

}
