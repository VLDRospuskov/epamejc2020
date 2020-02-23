package sea_battle.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {

    private BufferedReader reader;

    public Reader() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String read() {
        String userInput = "";

        try {
            userInput = reader.readLine();
        } catch (IOException e) {
            System.out.println("Wrong entry! Try again!");
            read();
        }

        return userInput;
    }

    public void close() {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
