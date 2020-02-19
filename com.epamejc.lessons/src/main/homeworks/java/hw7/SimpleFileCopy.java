package homeworks.java.hw7;

import lombok.SneakyThrows;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Arrays;

public class SimpleFileCopy {

    public void run() {
        copyFile();
    }

    @SneakyThrows
    private void copyFile() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long startTime = timestamp.getTime();

        char[] text = new char[256];
        FileReader fr = null;
        FileWriter fw = null;

        try {
            fr = new FileReader("com.epamejc.lessons/src/main/homeworks/java/hw7/hoking.txt");
            fw = new FileWriter("com.epamejc.lessons/src/main/homeworks/java/hw7/NewFile.txt");
            while (fr.read(text) != -1) {
                fw.write(text);
            }
        } catch (IOException e) {
            System.err.println("Read or write error! =)");
        } finally {
            if (fr != null) {
                fr.close();
            }
            if (fw != null) {
                fw.close();
            }

        }

        timestamp = new Timestamp(System.currentTimeMillis());
        long endTime = timestamp.getTime();
        System.out.println("Simple work time in mls: " + (endTime - startTime));

    }

    @SneakyThrows
    private void readFile() {
        FileReader fr = null;
        char[] chars = new char[256];

        try {
            fr = new FileReader("com.epamejc.lessons/src/main/homeworks/java/hw7/hoking.txt");
            fr.read(chars);
            System.out.println(Arrays.toString(chars));
        } catch (IOException e) {
            System.err.println("Can't find file.");
        } finally {
            if (fr != null) {
                fr.close();
            }
        }
    }

    @SneakyThrows
    private void writeFile() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("com.epamejc.lessons/src/main/homeworks/java/hw7/NewFile.txt");
            fw.write("Hello Vitaly!");
        } catch (IOException e){
            System.err.println("Can't write file.");
        } finally {
            if (fw != null) {
                fw.close();
            }
        }

    }

}
