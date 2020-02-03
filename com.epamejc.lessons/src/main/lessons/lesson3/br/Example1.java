package main.lessons.lesson3.br;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Example1 {

    /**
     *
     * @Author
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int i = Integer.parseInt(reader.readLine());
        }catch (NumberFormatException e) {
            throw new Exception(e);
        }
        finally {
            reader.close();
        }
    }

    private static void init() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int i = Integer.parseInt(reader.readLine());
        }
    }
}
