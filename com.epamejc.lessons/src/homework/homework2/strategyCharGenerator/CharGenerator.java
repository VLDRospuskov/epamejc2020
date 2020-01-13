package homework.homework2.strategyCharGenerator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class CharGenerator {

    void generate () {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {

                System.out.print("Enter 'rows columns' or type 'exit': ");
                String userInput = reader.readLine();
                String[] rowsAndColumns = userInput.split(" ", 2);

                if (userInput.equals("exit")) {
                    System.out.println("Generator stoped!");
                    break;
                } else if (rowsAndColumns.length == 2 && isPositiveAndNotZero(rowsAndColumns[0]) && isPositiveAndNotZero(rowsAndColumns[1])) {

                    int rows = Integer.parseInt(rowsAndColumns[0]);
                    int columns = Integer.parseInt(rowsAndColumns[1]);

                    RandomArray randomArray = new RandomArray();
                    char[][] charArray = randomArray.create(rows, columns);

                    while (true) {
                        System.out.print("Select strategy even/odd or type 'next': ");
                        String userStrategy = reader.readLine();

                        if (userStrategy.equals("next")) {
                            break;
                        } else {
                            selectStrategy(userStrategy, charArray, rows, columns);
                        }
                    }
                } else {
                    System.out.println("Incorrect format\n");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void selectStrategy (String strategy, char[][] charArray, int rows, int columns) {

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

    private boolean isPositiveAndNotZero (String str) {
        String regexInteger = "^-?\\d+$";
        return str.matches(regexInteger) && Integer.parseInt(str) > 0;
    }
}
