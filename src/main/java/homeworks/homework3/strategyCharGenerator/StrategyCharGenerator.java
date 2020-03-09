package homeworks.homework3.strategyCharGenerator;

import homeworks.homework3.allInOne.ThreadController;

import java.util.ArrayList;

public class StrategyCharGenerator {

    public void generate(String userInput, String userStrategy) {

        String[] rowsAndColumns = userInput.split(" ", 2);

        if (rowsAndColumns.length == 2 && isPositiveAndNotZero(rowsAndColumns[0]) && isPositiveAndNotZero(rowsAndColumns[1])) {

            int rows = Integer.parseInt(rowsAndColumns[0]);
            int columns = Integer.parseInt(rowsAndColumns[1]);

            RandomArray randomArray = new RandomArray();
            synchronized (ThreadController.sync) {
                char[][] charArray = randomArray.create(rows, columns);

                selectStrategy(userStrategy, charArray, rows, columns);
            }

        } else {
            System.out.println("Incorrect format\n");
        }
    }

    private void selectStrategy(String strategy, char[][] charArray, int rows, int columns) {

        if (strategy.equalsIgnoreCase("even")) {
            StrategyEven strategyEven = new StrategyEven();
            ArrayList<Character> result = strategyEven.createArray(charArray, rows, columns);
            strategyEven.show(result);
        } else if (strategy.equalsIgnoreCase("odd")) {
            StrategyOdd strategyOdd = new StrategyOdd();
            ArrayList<Character> result = strategyOdd.createArray(charArray, rows, columns);
            strategyOdd.show(result);
        } else {
            System.out.println("Incorrect input");
        }
    }

    private boolean isPositiveAndNotZero(String str) {
        String regexInteger = "^-?\\d+$";
        return str.matches(regexInteger) && Integer.parseInt(str) > 0;
    }
}
