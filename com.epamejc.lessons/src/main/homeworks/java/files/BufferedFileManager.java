package homeworks.java.files;

import java.io.*;

public class BufferedFileManager {

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

    public void writeFile(String text, String fileName) {

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)))) {
            writer.write(text);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

}
