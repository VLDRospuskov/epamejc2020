package lessons.java.lesson21.example4;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        readFileInformation();
    }
//    NUMBERS: 1
    private static void readFileInformation() {
//        try (FileInputStream in = new FileInputStream("file.txt")) {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("file.txt"))) {
            System.out.println((char) in.read()); // NUN
            in.mark(2);
            System.out.println((char) in.read());
            in.reset();
            System.out.println((char) in.read());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
