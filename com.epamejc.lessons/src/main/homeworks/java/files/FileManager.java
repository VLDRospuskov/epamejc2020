package homeworks.java.files;

import lombok.SneakyThrows;

import java.io.*;

public class FileManager {

    public String readFile(String fileName) {

        char[] text = null;
        try (FileInputStream stream = new FileInputStream(fileName)) {
            int length = stream.available();
            text = new char[length];
            InputStreamReader reader = new InputStreamReader(stream);
            reader.read(text);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return new String(text);

    }

    public void writeFile(String text, String fileName) {

        try (FileOutputStream stream = new FileOutputStream(fileName)) {
            OutputStreamWriter writer = new OutputStreamWriter(stream);
            writer.write(text, 0, text.length());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

}
