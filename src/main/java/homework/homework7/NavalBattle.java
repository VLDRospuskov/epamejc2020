package homework.homework7;

import homework.homework7.controllers.BotController;
import homework.homework7.controllers.Controller;
import homework.homework7.controllers.PlayerController;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NavalBattle {

    @SneakyThrows
    public void start() {

        try {

            System.out.print("Choose your opponent 'bot or player': ");
            String userPlayer = ConsoleReader.reader.readLine();
            Controller opponentController = selectPlayer("userPlayer");


        } catch (IOException | NoSuchOpponentException ex) {
            System.out.println("Oops we got an exception" + ex.getMessage());
        } finally {
            ConsoleReader.reader.close();
        }
    }

    private Controller selectPlayer(String userChoice) {

        if (userChoice.equalsIgnoreCase("bot")) {
            return new BotController();
        } else if (userChoice.equalsIgnoreCase("player")) {
            return new PlayerController();
        } else {
            System.out.printf("Unrecognized symbol '%s'!\n", userChoice);
            throw new NoSuchOpponentException();
        }
    }

}
