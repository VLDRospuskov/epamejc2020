package homeworks.seabattle_2_players;

import static homeworks.seabattle_2_players.Player.TOTAL_SCORE;

public class SeaBattle {

    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public void play() {
        initialize();
        playSeaBattle();
//        end();
    }

    private void initialize() {
        player1 = new Player("1st Player");
        player2 = new Player("2nd Player");
        exchangeFields(player1, player2);
    }

    private void exchangeFields(Player player1, Player player2) {
        player1.setEnemyField(player2.getPlayerField());
        player2.setEnemyField(player1.getPlayerField());
    }

    private void playSeaBattle() {
        currentPlayer = player2;

        while (currentPlayer.getScore() < TOTAL_SCORE) {
            changeTurns();
            System.out.println("---------------------------------------------");
            System.out.println("               " + currentPlayer.getName().toUpperCase() + "'S TURN!");
            currentPlayer.turn();
        }
    }

    private void changeTurns() {
        if (currentPlayer.equals(player1)) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

}
