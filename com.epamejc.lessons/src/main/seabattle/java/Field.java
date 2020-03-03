package seabattle.java;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static seabattle.java.Utils.*;

@AllArgsConstructor
@Data
public class Field {

    protected List<ArrayList<Cell>> field;
    protected ArrayList<Ship> ships;


    public Field() {
        field = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Cell> row = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                row.add(new Cell());
            }
            field.add(row);
        }
        ships = new ArrayList<>();
    }

    public void printField() {
        for (ArrayList row : field) {
            ArrayList<Cell> col = row;
            for (Cell cell : col) {
                System.out.print(cell + "  ");
            }
            System.out.println("");
        }
        clearScreen();
    }

}
