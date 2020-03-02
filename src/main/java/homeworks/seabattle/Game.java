package homeworks.seabattle;

import homeworks.seabattle.battlefield.FieldInitiator;
import homeworks.seabattle.controllers.Controller;
import homeworks.seabattle.controllers.PlayerController;
import lombok.SneakyThrows;

public class Game {

    @SneakyThrows
    public void run () {

        Controller player1 = new PlayerController();

        OpponentSelector selector = new OpponentSelector();
        Controller player2 = selector.select();

        FieldInitiator initiator1 = new FieldInitiator();
        Positions.opponentShipPositions = initiator1.init();

        FieldInitiator initiator2 = new FieldInitiator();
        Positions.playerShipPositions = initiator2.init();

        while (true) {

            player1.makeMove();
            player2.makeMove();

        }


    }

}
