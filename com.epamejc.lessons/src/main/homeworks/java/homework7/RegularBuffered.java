package main.homeworks.java.homework7;

import java.io.*;

public class RegularBuffered {

    private static final String TOREGULAR = "REGULAR.out";
    private static final String TOBUFFERED = "BUFFERED.out";

    public void writeToFile(String text) {
        try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(TOREGULAR))) {
            osw.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void BufferedWriteToFile(String text) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(TOBUFFERED)))) {
            bw.write(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String readFromFile(String from) {
        StringBuilder text = new StringBuilder();
        try (FileInputStream file = new FileInputStream(from)) {
            InputStreamReader in = new InputStreamReader(file);
            int c;
            while ((c = in.read()) != -1)
            text.append((char)c);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    public String BufferedReadFromFile(String from) {
        StringBuilder text = new StringBuilder();
        try (FileInputStream file = new FileInputStream(from)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(file));
            String s;
            while ((s = in.readLine()) != null)
                text.append((s)).append("\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }
}
