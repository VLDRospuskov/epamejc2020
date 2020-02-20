package homeworks.java.files;

import java.io.*;

public class FileManager {

    /**
     * @param fileName source file path
     * @return {@code String} which contains text from source file.
     */
    public String readFile(String fileName) {

        char[] text = null;
        try (FileInputStream stream = new FileInputStream(fileName)) {
            text = new char[stream.available()];
            InputStreamReader reader = new InputStreamReader(stream);
            reader.read(text);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return new String(text);

    }

    /**
     * @param text     {@code String} text to write
     * @param fileName output file path
     */
    public void writeFile(String text, String fileName) {

        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName))) {
            writer.write(text, 0, text.length());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

}
