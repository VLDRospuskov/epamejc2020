package homeworks.homework3.strategyCharGenerator;

import java.util.ArrayList;

class StrategyOdd implements Strategy {

    @Override
    public ArrayList<Character> createArray(char[][] charArray, int rows, int columns) {
        ArrayList<Character> even = new ArrayList<>();
        for (int i=0; i<rows; i=i+2) {
            for (int j=0; j<columns; j=j+2) {
                even.add(charArray[i][j]);
            }
        }
        return even;
    }
}
