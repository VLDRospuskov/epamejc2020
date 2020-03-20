package seabattle.java.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Field {

    private int id;
    private List<ArrayList<Cell>> field;
    private ArrayList<Ship> ships;


    public Field(int id) {
        this.id = id;
        field = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Cell> row = new ArrayList<>(10);
            for (int j = 0; j < 10; j++) {
                row.add(new Cell());
            }
            field.add(row);
        }
        ships = new ArrayList<>(10);
    }

}
