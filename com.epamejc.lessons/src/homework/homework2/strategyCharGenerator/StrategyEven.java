package homework.homework2.strategyCharGenerator;

import java.util.ArrayList;

class StrategyEven implements Strategy {

    @Override
    public ArrayList<Character> createArray (char[][] charArray, int rows, int columns) {
        ArrayList<Character> odd = new ArrayList<>();
        for (int i=1; i<rows; i=i+2) {
            for (int j=1; j<columns; j=j+2) {
                odd.add(charArray[i][j]);
            }
        }
        return odd;
    }
}
