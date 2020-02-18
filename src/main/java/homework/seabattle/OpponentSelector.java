package homework.seabattle;

import homework.seabattle.controllers.BotController;
import homework.seabattle.controllers.Controller;
import homework.seabattle.controllers.PlayerController;
import lombok.SneakyThrows;

import java.io.IOException;

public class OpponentSelector {

    public void start() {

        try {

            System.out.print("Choose your opponent 'bot or player': ");
            String userPlayer = ConsoleReader.reader.readLine();
            Controller opponentController = selectPlayer("userPlayer");


        } catch (IOException | NoSuchOpponentException ex) {
            System.out.println("Oops we got an exception" + ex.getMessage());
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
