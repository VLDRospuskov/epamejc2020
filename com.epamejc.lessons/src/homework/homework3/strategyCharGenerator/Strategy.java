package homework.homework3.strategyCharGenerator;

import homework.homework3.allInAll.Colors;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

interface Strategy {

    ArrayList<Character> createArray (char[][] charArray, int rows, int columns);

    default void show (ArrayList<Character> strategyArray) {
        for (Object o : strategyArray) {
            System.out.print(Colors.colors[ThreadLocalRandom.current().nextInt(1, 9)]
                    + " " + o + " " + Colors.colors[0]);
        }
        System.out.println();
    }
}
