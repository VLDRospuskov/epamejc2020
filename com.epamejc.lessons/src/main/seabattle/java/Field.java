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
        System.out.println("");
        System.out.println("    A  B  C  D  E  F  G  H  I  J");
        int index = 1;
        for (ArrayList row : field) {
            System.out.printf("%2d  ", index);
            ArrayList<Cell> col = row;
            for (Cell cell : col) {
                System.out.print(cell + "  ");
            }
            index++;
            System.out.println("");
        }
        clearScreen();
    }

}
