package homework7;

import java.io.*;

public class BFileManager {
    public String readFile(String filePatch) {
        char[] text = null;
        try (FileInputStream fin = new FileInputStream(filePatch)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePatch)));
            text = new char[fin.available()];
            reader.read(text);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return new String(text);
    }

    public void writeFile(String filePatch, String text) {
        try (BufferedWriter fout = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePatch)))) {
            fout.write(text);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
