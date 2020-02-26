package homework.seabattle;

import homework.seabattle.battlefield.FieldInitiator;
import homework.seabattle.controllers.Controller;
import homework.seabattle.controllers.PlayerController;
import lombok.SneakyThrows;

public class Game {

    @SneakyThrows
    public void run () {

        Controller player1 = new PlayerController();

        OpponentSelector selector = new OpponentSelector();
        Controller player2 = selector.select();

        FieldInitiator initiator = new FieldInitiator();
        initiator.init();

        while (true) {

            player1.makeMove();
            player2.makeMove();

        }


    }

}
