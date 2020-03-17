package homeworks.newSeabattle.logic;

import homeworks.newSeabattle.data.players.Player;
import homeworks.utility.helper.Helper;
import lombok.SneakyThrows;

import static homeworks.newSeabattle.data.enums.Messages.*;
import static homeworks.newSeabattle.logic.GameGeneration.*;

public class SeaBattle {
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public void play() {
        initializeGame();
    }

    private void initializeGame() {
        generatePlayersWithNames();
        generateField(player1);
        generateField(player2);
    }

    @SneakyThrows
    private void generatePlayersWithNames() {
        int gameType = Helper.getInt(GAME_CHOOSING.toString());
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
    }

}
