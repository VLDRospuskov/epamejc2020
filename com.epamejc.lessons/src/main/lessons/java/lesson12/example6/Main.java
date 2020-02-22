package lessons.java.lesson12.example6;

import java.io.*;

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
