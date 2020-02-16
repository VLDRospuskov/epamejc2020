package seaBattle.logic;

import seaBattle.data.Cell;

import java.util.ArrayList;
import java.util.List;

public class ModulesOperator {

    public static List<Cell> getModuleUp(int xCoord, int yCoord, int shipDecks, List<Cell> field) {
        int yCoord2 = yCoord - shipDecks + 1;
        List<Cell> testList = new ArrayList<>();
        for (Cell c : field) {
            if ((c.getxCoord() >= xCoord - 1 && c.getxCoord() <= xCoord + 1)
                    && (c.getyCoord() <= yCoord2 && c.getyCoord() >= yCoord - 1)) {
                testList.add(c);
            }
        }
        return testList;
    }
}
