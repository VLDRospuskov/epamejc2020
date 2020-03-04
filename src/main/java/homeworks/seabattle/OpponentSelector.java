package homeworks.seabattle;

import homeworks.seabattle.controllers.BotController;
import homeworks.seabattle.controllers.Controller;
import homeworks.seabattle.controllers.PlayerController;
import lombok.SneakyThrows;


public class OpponentSelector {

    @SneakyThrows
    public Controller select() {
        while (true) {
            System.out.print("Choose your opponent 'bot' or 'player': ");
            String userPlayer = ConsoleReader.reader.readLine();
            if (userPlayer.equalsIgnoreCase("bot")) {
                return new BotController();
            } else if (userPlayer.equalsIgnoreCase("player")) {
                return new PlayerController();
            } else {
                System.out.println("There is no such opponent!");
            }
        }
    }
}
