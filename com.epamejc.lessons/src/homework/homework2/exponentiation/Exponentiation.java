package homework.homework2.exponentiation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Exponentiation {

    double product = 1;

    void run () {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
                System.out.print("Enter a base or 'exit': ");
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
                        } else if (determineSteppeType(userSteppe).equals(TypeOfSteppe.INTEGER)) {

                            int steppe = Integer.parseInt(userSteppe);
                            double result = exponent(number, steppe);
                            System.out.println(result);

                        } else if (determineSteppeType(userSteppe).equals(TypeOfSteppe.DOUBLE)) {

                            double steppe = Double.parseDouble(userSteppe);
                            double result = Math.pow(number, steppe);
                            System.out.println(result);

                        } else {
                            System.out.println("Steppe must be double or integer");
                        }
                    }
                } else {
                    System.out.println("Base must be double or integer");
                }
            }
        } catch (Exception ex)  {
            ex.printStackTrace();
        }
    }

    private double exponent (double base, int steppe) {
        if (steppe > 0) {
            product *= base;
            steppe--;
            exponent(base, steppe);
            return product;
        } else if (steppe < 0) {
            product *= 1/base;
            steppe++;
            exponent(base, steppe);
            return product;
        } else {
            return product;
        }
    }

    private boolean isNumeric (String str) {
        String regexDecimal = "^-?\\d*\\.\\d+$";
        String regexInteger = "^-?\\d+$";
        return str.matches(regexDecimal + "|" + regexInteger);
    }

    private TypeOfSteppe determineSteppeType (String str) {
        String regexDecimal = "^-?\\d*\\.\\d+$";
        String regexInteger = "^-?\\d+$";
        if (str.matches(regexDecimal)) {
            return TypeOfSteppe.DOUBLE;
        } else if (str.matches(regexInteger)) {
            return TypeOfSteppe.INTEGER;
        } else {
            return TypeOfSteppe.NAN;
        }
    }
}
