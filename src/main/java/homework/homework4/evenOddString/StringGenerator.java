package homework.homework4.evenOddString;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringGenerator {

    void generate () {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {

                System.out.print("Enter string: ");
                String userString = reader.readLine();

                System.out.print("Type even/odd or exit: ");
                String userStrategy = reader.readLine();

                if (userStrategy.equalsIgnoreCase("exit")) {
                    System.out.println("Generator stoped!");
                    break;
                } else {
                    handleUserInput(userStrategy, userString);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void handleUserInput (String userStrategy, String userString) {
        if (isStrategy(userStrategy)) {
            selectStrategy(userStrategy, userString);
        } else {
            System.out.println("Incorrect format");
        }
    }

    private void selectStrategy(String strategy, String string) {
        if (strategy.equalsIgnoreCase("even")) {
            Even even = new Even();
            even.createString(string);
        } else {
            Odd odd = new Odd();
            odd.createString(string);
        }
    }

    private boolean isStrategy(String str) {
        String regexEven = "even";
        String regexOdd = "odd";
        String regexStrategy = regexEven + "|" + regexOdd;
        Pattern patternStrategy = Pattern.compile(regexStrategy, Pattern.CASE_INSENSITIVE);
        Matcher matcherStrategy = patternStrategy.matcher(str);
        return matcherStrategy.matches();
    }
}
