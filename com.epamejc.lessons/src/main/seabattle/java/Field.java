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

    public Field() {
        field = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Cell> row = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                row.add(new Cell());
            }
            field.add(row);
//            field.
        }
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

//    public void setShip() {
//        field.get(1).get(1).setStatus(1);
//        field.get(1).get(2).setStatus(1);
//        field.get(1).get(3).setStatus(1);
//        field.get(1).get(4).setStatus(1);
//    }
}
