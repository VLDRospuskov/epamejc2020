package Home_works.Sea_Battle;

import Home_works.Sea_Battle.field.FieldCreator;

import java.util.ArrayList;
import java.util.Arrays;

public class Move {

    private String move = "x";
    private String blow = "✱";
    private String ship = "0";
    private String dot = ".";
    private int first;
    private int second;

    public boolean makeMove(FieldCreator battleFieldPlayerSecond, FieldCreator moveFieldPlayerFirst) {
        String cell = battleFieldPlayerSecond.getCell(this.first, this.second);

        if (cell.equals(dot)) {
            System.out.println("You Miss! Try again");
            battleFieldPlayerSecond.changeCell(this.first, this.second, move);
            moveFieldPlayerFirst.changeCell(this.first, this.second, move);
            return true;
        } else if (cell.equals(move)) {
            System.out.println("You have already hit this point, try another coordinate");
            return false;
        } else if (cell.equals(ship)) {
            System.out.println("Congratulations you hit the target");
            battleFieldPlayerSecond.changeCell(this.first, this.second, blow);
            moveFieldPlayerFirst.changeCell(this.first, this.second, blow);
            return true;
        } else if (cell.equals(blow)) {
            return false;
        }
        return false;
    }

    public Move(String first, Integer second) {
        this.first = changeFirst(first);
        this.second = second;
    }

    private int changeFirst(String first) {
        ArrayList<String> alphabeticArr = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J"));
        for (int i = 0; i < alphabeticArr.size(); i++) {
            if (first.equals(alphabeticArr.get(i))) {
                return i;
            }
        }
        throw new IllegalArgumentException(first);
    }
}
