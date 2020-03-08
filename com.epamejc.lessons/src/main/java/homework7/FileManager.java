package homework7;

import java.io.*;

public class FileManager {
    public String readFile(String filePatch) {
        char[] text = null;
        try (FileInputStream fin = new FileInputStream(filePatch)) {
            text = new char[fin.available()];
            InputStreamReader reader = new InputStreamReader(fin);
            reader.read(text);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return new String(text);
    }

    public void writeFile(String filePatch, String text) {
        try (FileOutputStream fou = new FileOutputStream(filePatch)) {
            // перевод строки в байты
            byte[] buffer = text.getBytes();
            fou.write(buffer, 0, buffer.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}

