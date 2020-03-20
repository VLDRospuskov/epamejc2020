package seabattle;

import lombok.SneakyThrows;
import seabattle.Players.Player;

public class Test {
    public Player player1 = new Player();
    public Player player2 = new Player();

    public Player whichPlayerTurn = player1;

    /*
        @SneakyThrows
        public void startGame() {
            player1.enemy = player2;
            player2.enemy = player1;
            player1.name = "Alex";
            player2.name = "Kristina";
            System.out.println("HELLO!");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String command;
            System.out.println("Shoot, " + whichPlayerTurn.name + "!");

            command = reader.readLine();
            while (!(command = reader.readLine()).equals("exit") && !gameOver()) {
                int aim = Integer.parseInt(command);
                if (whichPlayerTurn.enemy.field[aim] == 1) {
                    whichPlayerTurn.enemy.field[aim] = 0;
                    whichPlayerTurn.enemy.shipsLeft--;
                    System.out.println("Great shoot!");
                    if (gameOver()) {
                        System.out.println(whichPlayerTurn.name + " wins!!!");
                    }
                } else {
                    System.out.println("U missed =(");
                }
                whichPlayerTurn = whichPlayerTurn.enemy;
                System.out.println("Shoot, " + whichPlayerTurn.name + "!");
            }
        }
    */
    @SneakyThrows
    public static void main(String[] args) {

        /*

        //Test game = new Test();
        //game.startGame();
        int[] values = new int[5];
        for (int i = 0; i < values.length; i++) {
            values[i] = new Random().nextInt(9);
        }
        Player player1 = new Player();
        Player player2 = new Player();
        player1.enemy = player2;
        player2.enemy = player1;
        player1.name = "Alex";
        player2.name = "Kristina";
        System.out.println("HELLO!");
        int[] myvalues = new int[5];
        Player currentPlayer = player1;
        int neededPoints = eveluate(values, values);

        int result;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do {
            currentPlayer = currentPlayer.enemy;
            System.out.println(currentPlayer.name + ", your turn!");
            String str = reader.readLine();
            if (str.equals("show")) {
                System.out.println(Arrays.toString(values));
            }
            String[] strs = str.split("");
            for (int i = 0; i < 5; i++) {
                myvalues[i] = Integer.parseInt(strs[i]);
            }
            result = eveluate(myvalues, values);
            System.out.println(currentPlayer.name + ", your result is: " + result);
            if (gameOver(values, myvalues)) {
                System.out.println(currentPlayer.name + " WON!");
            }
        } while (!gameOver(values, myvalues));
        System.out.println("Values were: " + Arrays.toString(values));

         */
    }

//    public boolean gameOver() {
//        return player1.shipsLeft == 0 || player2.shipsLeft == 0;
//    }

    public static boolean gameOver(int[] real, int[] suggested) {
        int result = 0;
        for (int i = 0; i < 5; i++) {
            if (real[i] == suggested[i]) {
                result++;
            }
        }
        return result == 5;
    }

    public static int eveluate(int[] real, int[] suggested) {
        int result = 0;
        for (int i = 0; i < suggested.length; i++) {
            for (int j = 0; j < real.length; j++) {
                if (real[j] == suggested[i]) {
                    if (i == j) {
                        result += 3;
                    } else {
                        result += 1;
                    }
                }
            }
        }
        return result;
    }

}