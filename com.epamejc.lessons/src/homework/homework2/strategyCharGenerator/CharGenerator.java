package homework.homework2.strategyCharGenerator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class CharGenerator {

    void generate () {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
                System.out.print("Select strategy A or B: ");
                String userStrategy = reader.readLine();

                if (userStrategy.equals("exit")) {
                    System.out.println("Generator stoped!");
                    break;
                }

                System.out.print("Enter 'rows columns' or type 'exit': ");
                String userInput = reader.readLine();
                String[] rowsAndColumns = userInput.split(" ", 2);

                if (rowsAndColumns.length == 2 && isPositiveAndNotZero(rowsAndColumns[0]) && isPositiveAndNotZero(rowsAndColumns[1])
                && isStrategy(userStrategy)) {
                    int rows = Integer.parseInt(rowsAndColumns[0]);
                    int columns = Integer.parseInt(rowsAndColumns[1]);
                    selectStrategy(userStrategy, rows, columns);
                } else if (userInput.equals("exit")) {
                    System.out.println("Generator stoped!");
                    break;
                } else {
                    System.out.println("Incorrect format\n");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void selectStrategy (String strategy, int rows, int columns) {
        StrategyA strategyA = new StrategyA();
        StrategyB strategyB = new StrategyB();

        if (strategy.equalsIgnoreCase("A")) {
            strategyA.setRandomChars(rows, columns);
        } else {
            strategyB.setRandomChars(rows, columns);
        }
    }

    private boolean isStrategy (String str) {
        String regexAorB = "[AaBb]";
        return str.matches(regexAorB);
    }

    private boolean isPositiveAndNotZero (String str) {
        String regexInteger = "^-?\\d+$";
        return str.matches(regexInteger) && Integer.parseInt(str) > 0;
    }
}
