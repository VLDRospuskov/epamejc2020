package homeworks.seabattle.logic;

import homeworks.seabattle.util.ConsoleReader;
import homeworks.seabattle.battlefield.BotFieldInitiator;
import homeworks.seabattle.battlefield.FieldInitiator;
import homeworks.seabattle.battlefield.PlayerFieldInitiator;
import homeworks.seabattle.controllers.BotController;
import homeworks.seabattle.controllers.Controller;
import homeworks.seabattle.controllers.PlayerController;
import lombok.SneakyThrows;


public class OpponentSelector {

    @SneakyThrows
    public Controller select() {

        FieldInitiator initiator;

        while (true) {

            System.out.print("Choose your opponent 'bot' or 'player': ");
            String userPlayer = ConsoleReader.reader.readLine();

            if (userPlayer.equalsIgnoreCase("bot")) {

                initiator = new BotFieldInitiator();
                initiator.init();
                return new BotController();

            } else if (userPlayer.equalsIgnoreCase("player")) {

                initiator = new PlayerFieldInitiator();
                initiator.init();
                return new PlayerController();

            } else {
                System.out.println("There is no such opponent!");
            }
        }
    }
}
