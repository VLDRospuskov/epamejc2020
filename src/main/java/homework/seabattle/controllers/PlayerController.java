package homework.seabattle.controllers;

import homework.seabattle.ConsoleReader;
import homework.seabattle.battlefield.Field;
import homework.seabattle.battlefield.FieldInitiator;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class PlayerController implements Controller {

    public List<Integer> hitPool = new ArrayList<>();
    public List<Integer> missPool = new ArrayList<>();

    @SneakyThrows
    public void makeMove() {

        FieldInitiator initiator = new FieldInitiator();
        System.out.println("Decide what cell to shoot: ");
        String shot = ConsoleReader.reader.readLine();
        int shotPosition = initiator.cells.indexOf(shot);

        if (shotPosition != -1) {

            if (initiator.shipPositions.contains(shotPosition)) {

                hitPool.add(shotPosition);
                Field field = new Field();
                field.printField();
                makeMove();

            } else {
                missPool.add(shotPosition);
            }
        } else {
            System.out.println("Invalid input");
            makeMove();
        }
    }
}
