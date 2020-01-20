package main.homeworks.homework2.strings.indexGeneration;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StringIndexGeneration stringIndexGeneration = new StringIndexGeneration();
        try {
            stringIndexGeneration.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
