package lessons.lesson12.example6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) {
       PrintWriter pw = null;
       try {

            pw = new PrintWriter(new BufferedWriter(new FileWriter("text.txt")));

            pw.println("I'm a sentence in a text-file.");
            pw.println("I'm a sentence in a text-file.");
            pw.println("I'm a sentence in a text-file."); // IOException
            pw.println("I'm a sentence in a text-file.");
       } catch (IOException e) {
            throw new RuntimeException(e);
       } finally {
           pw.close();
       }

    }
}
