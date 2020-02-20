package homeworks.java.files;

import java.io.*;

/**
 * extends {@link FileManager} by wrapping Reader/Writer with Buffered Reader/Writer
 */
public class BufferedFileManager extends FileManager {

    /**
     * @param fileName source file path
     * @return {@code String} which contains text from source file.
     */
    @Override
    public String readFile(String fileName) {

        char[] text = null;
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            text = new char[fileInputStream.available()];
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
    @Override
    public void writeFile(String text, String fileName) {

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)))) {
            writer.write(text);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

}
