package homework.homework2.exponentiation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Exponentiation {

    double product = 1;

    void run () {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
                System.out.print("Enter a number to elevate or 'exit': ");
                String userNumber = reader.readLine();

                if (userNumber.equalsIgnoreCase("exit")) {
                    System.out.println("Calculator stopped!");
                    break;
                } else if (isNumeric(userNumber)) {

                    double number = Double.parseDouble(userNumber);

                    while (true) {

                        product = 1;
                        System.out.print("Enter steppe or 'next': ");
                        String userSteppe = reader.readLine();

                        if (userSteppe.equalsIgnoreCase("next")) {
                            break;
                        } else if (isNumeric(userSteppe)) {
                            double steppe = Double.parseDouble(userSteppe);
                            double result = elevate(number, steppe);
                            System.out.println(result);
                        } else {
                            System.out.println("Steppe must be double or integer");
                        }
                    }
                } else {
                    System.out.println("Incorrect input");
                }
            }
        } catch (Exception ex)  {
            ex.printStackTrace();
        }
    }


    private double elevate (double number, double steppe) {
        if (steppe > 0) {
            product *= number;
            steppe--;
            elevate(number, steppe);
            return product;
        } else if (steppe < 0) {
            product *= number;
            steppe++;
            elevate(number, steppe);
            return product;
        } else {
            return product;
        }
    }

    private boolean isNumeric (String str) {
        String regexDecimal = "^-?\\d*\\.\\d+$";
        String regexInteger = "^-?\\d+$";
        String regexDouble = regexDecimal + "|" + regexInteger;
        return str.matches(regexDouble);
    }
}
