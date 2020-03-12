package homework.homework3;

import homework.homework3.arrays.RandomCharTable;
import homework.homework3.arrays.RandomPyramidalMatrix;

public class Main {
    public static void main(String[] args) {
        RandomPyramidalMatrix pyramidalArray = new RandomPyramidalMatrix(10);
        pyramidalArray.print();
        System.out.println(pyramidalArray.toStringStrategyA());
        System.out.println(pyramidalArray.toStringStrategyB());

        RandomCharTable twoDimensionalArray = new RandomCharTable(10, 10);
        twoDimensionalArray.print();
        System.out.println(twoDimensionalArray.toStringStrategyA());
        System.out.println(twoDimensionalArray.toStringStrategyB());
    }
}
