package seabattle;

import homeworks.InputReader;

public class BattleShipGame {
    
    private static void checkWinner(Player player1, Player player2) {
        if (player1.myField.getShips()
                           .size() == 0) {
            System.out.println("Player 2 win!");
        }
        if (player2.myField.getShips()
                           .size() == 0) {
            System.out.println("Player 1 win!");
        }
    }
    
    private static void skip30rows() {
        for (int i = 0; i < 30; i++) {
            System.out.println('.');
        }
    }
    
    private static Player chooseSecondPlayer() {
        if ("1".equals(InputReader.nextString()
                                  .toLowerCase())) {
            return new Bot();
        } else {
            return new Player();
        }
    }
    
    public void start() {
        Player player1 = new Player();
        System.out.println("Player 1");
        player1.selectFieldFillStrategy();
        Player player2 = new Player();//chooseSecondPlayer();
        System.out.println("Player2");
        player2.selectFieldFillStrategy();
        player1.setOpponentsFieldData(player2.getMyField());
        player2.setOpponentsFieldData(player1.getMyField());
        System.out.println("My");
        player1.view.printField(player1.myField);
        System.out.println("Opo");
        player1.view.printField(player1.opponentsFieldData);
        player1.view.printField(player1.opponentsField);
        while (isOneOfFieldsIsEmpty(player1, player2)) {
            player2Turn(player1, "Player one.");
            if (isOneOfFieldsIsEmpty(player1, player2)) {
                player2Turn(player2, "Player two.");
            }
        }
        checkWinner(player1, player2);
    }
    
    private boolean isOneOfFieldsIsEmpty(Player player1, Player player2) {
        return player1.myField.getShips()
                              .size() > 0 && player2.myField.getShips()
                                                            .size() > 0;
    }
    
    private void player2Turn(Player player2, String s) {
        skip30rows();
        System.out.println(s + " Input any symbol to continue");
        InputReader.nextString();
        player2.shotMethod();
    }
    
}
