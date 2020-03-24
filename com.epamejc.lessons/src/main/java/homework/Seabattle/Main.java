package homework.Seabattle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            new Game().start(reader);
        } catch (IOException e) {
            System.err.println("Unexpected IOException");
            throw new Error("Unexpected IOException: " + e);
        }
    }
}
