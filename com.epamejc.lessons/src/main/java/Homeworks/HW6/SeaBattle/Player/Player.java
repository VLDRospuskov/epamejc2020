package Homeworks.HW6.SeaBattle.Player;

import Homeworks.HW6.SeaBattle.Grid.Grid;
import Homeworks.HW6.SeaBattle.Input.Input;

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
