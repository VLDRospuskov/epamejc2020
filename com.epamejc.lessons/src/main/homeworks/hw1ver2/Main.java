package main.homeworks.hw1ver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static main.homeworks.hw1.enums.Messages.ENTER_MESSAGE;
import static main.homeworks.hw1.enums.Messages.EXIT_COMMAND;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(ENTER_MESSAGE.toString());

        String line = buffer.readLine();

        TrafficLight.getColor(line);

        TrafficLight.checkForExit(line);

        buffer.close();
    }
}
