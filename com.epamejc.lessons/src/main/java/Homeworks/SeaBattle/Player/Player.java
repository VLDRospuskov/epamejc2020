package Homeworks.SeaBattle.Player;

import Homeworks.SeaBattle.Grid.Grid;
import Homeworks.SeaBattle.Input.Input;

public class Player {

    private static int players = 0;

    String name;
    Grid grid;

    public Player() {
        // person for now
        players++;
        grid = new Grid();
        askName();
        placeShips();
    }

    private void askName() {
        System.out.println("Player " + players + " please enter your name: ");
        this.name = Input.readLine();
    }

    public void placeShips() {
        System.out.println(name + ", please place your ships:");
    }
}
