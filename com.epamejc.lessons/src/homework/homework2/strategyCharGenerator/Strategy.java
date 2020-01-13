package homework.homework2.strategyCharGenerator;

import java.util.ArrayList;

interface Strategy {

    ArrayList<Character> createArray (char[][] charArray, int rows, int columns);

    default void show (ArrayList<Character> strategyArray) {
        for (Object o : strategyArray) {
            System.out.print(" " + o + " ");
        }
        System.out.println();
    }
}
