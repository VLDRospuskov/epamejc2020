package lessons.java.lesson12.example9;

import lombok.SneakyThrows;

import java.io.FileReader;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main {

    public static void main(String[] args) {
        try (PipedInputStream pipeIn = new PipedInputStream();
             PipedOutputStream pipeOut = new PipedOutputStream(pipeIn)) {
            int[] toRead;

            for (int i = 0; i < 20; i++) {
                pipeOut.write(i);
            }
            int willRead = pipeIn.available();
            toRead = new int[willRead];

            for (int i = 0; i < willRead; i++) {
                toRead[i] = pipeIn.read();
                System.out.print(toRead[i] + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
