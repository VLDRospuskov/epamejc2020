package main.homeworks.seabattle.player;

import main.homeworks.seabattle.field.PlayerField;
import main.homeworks.seabattle.field.Ship;
import main.homeworks.seabattle.game.Game;
import main.homeworks.seabattle.interfaces.ShipDestructionListener;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.ArrayList;

@Data
@NoArgsConstructor
public class Player implements ShipDestructionListener {

    public String name;
    public ArrayList<Ship> ships;
    public int[] shipsLengths = {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};
    public PlayerField field;
    public PlayerField oppositeField;

    public Player(String name) {
        this.ships = new ArrayList<>();
        this.name = name;
        field = new PlayerField(name);
    }

    public String getInputString() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = "";
        try {
            s = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return s;
    }

    public AbstractMap.SimpleEntry<Character, Integer> handleCoordinatesInput() {
        String s = getInputString();

        String[] point = s.split(" ");
        Character letter = ' ';
        Integer number = 0;

        try {
            letter = point[0].charAt(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            number = Integer.parseInt(point[1]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return new AbstractMap.SimpleEntry<>(letter, number);
    }

    public Ship handleShipPlacement(int length) {
        String s = getInputString();

        String[] point = s.split(" ");
        Character letter = ' ';
        Integer number = 0;
        Integer direction = -1;

        try {
            letter = point[0].charAt(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            number = Integer.parseInt(point[1]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        if (length > 1) {
            try {
                direction = Integer.parseInt(point[2]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        if (direction == 0) {
            int letIndex = field.letters.indexOf(letter);
            if (length + letIndex > field.size) {
                throw new IllegalArgumentException("This ship won't fit");
            }
            if (field.isThereShipCellAround(letter, number) ||
                    (field.isThereShipCellAround(field.letters.get(letIndex + length - 1), number))) {
                throw new IllegalArgumentException("Unable to place a ship, there is one nearby");
            }
        }

        if (direction == 1) {
            if (length + number > field.size) {
                System.out.println("This ship won't fit");
            }
            if (field.isThereShipCellAround(letter, number) ||
                    (field.isThereShipCellAround(letter, number + length - 1))) {
                throw new IllegalArgumentException("Unable to place a ship, there is one nearby");
            }
        }

        Ship ship =  new Ship(length, direction, letter, number);

        return ship;
    }

    public void move() {
        Boolean hitFlag = false;
        System.out.println("Choose coordinates of a target (in a format 'letter number'): ");
        AbstractMap.SimpleEntry<Character, Integer> coord = handleCoordinatesInput();

        hitFlag = oppositeField.isShipHit(coord.getKey(), coord.getValue());
        if (hitFlag) {
            oppositeField.handleShipHit(coord.getKey(), coord.getValue());
            System.out.println("Enemy's ship is hit, give it another try.");
            this.move();
        } else {
            System.out.println("You missed, sorry.");
            oppositeField.handleShotMissed(coord.getKey(), coord.getValue());
            return;
        }
    }

    public void addShips() {
        for (int i = 0; i < shipsLengths.length; i++) {

            System.out.println("Placing ship of length " + shipsLengths[i]);
            System.out.println("Enter coordinates and direction " +
                    "(in a format 'letter number' where the last number " +
                    "is 0 (horizontal direction) or 1 (vertical)): ");

            while (true) {
                try {
                    Ship ship = handleShipPlacement(shipsLengths[i]);
                    ship.setShipId(i);
                    ship.setOwner(this);
                    ships.add(ship);
                    field.addShip(ship);
                    break;
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
        }
        field.setPlacingShipsFlag(false);
    }

    @Override
    public void shipDestroyed(Ship ship) {
        ships.remove(ship);
        Game.endGame(this);
    }
}
