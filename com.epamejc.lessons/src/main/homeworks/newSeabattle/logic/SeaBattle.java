package homeworks.newSeabattle.logic;

import homeworks.newSeabattle.data.players.Player;

import static homeworks.newSeabattle.logic.IO.showFields;
import static homeworks.newSeabattle.logic.Util.generateComputer;
import static homeworks.newSeabattle.logic.Util.generateUser;

public class SeaBattle {
    private Player player1;
    private Player player2;

    public void play() {
        initializeGame();
        showFields(player1, player2);
    }

    private void initializeGame() {
        generatePlayers();
        generateFields();
    }

    private void generateFields() {
        FieldGenerator FG = new FieldGenerator();
        FG.generateField(player1);
        FG.generateField(player2);
    }

    private void generatePlayers() {
        int gameType = IO.getGameType();

        switch (gameType) {
            case 0 : {
                player1 = generateComputer();
                player2 = generateComputer();
                break;
            } case 1 : {
                player1 = generateUser();
                player2 = generateComputer();
                break;
            } case 2 : {
                player1 = generateUser();
                player2 = generateUser();
                break;
            }
        }

        player1.setActive(true);
    }

}
