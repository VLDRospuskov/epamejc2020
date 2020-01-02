package main.homeworks.hw1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static main.homeworks.hw1.enums.Messages.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        boolean cond = true;

        while (cond) {

            System.out.println(ENTER_MESSAGE.toString());

            String line = buffer.readLine();

            if (line.equalsIgnoreCase(EXIT_COMMAND.toString())) {
                cond = false;
                continue;
            }

            TrafficLight.getColor(line);

        }

        buffer.close();
    }
}
