package homework.homework2.dozensCounter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Counter {

    int dozens = 10;
    int count = 1;

    void count () {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {

                dozens = 10;
                count = 1;

                System.out.print("Enter number or 'exit': ");
                String userNumber = reader.readLine();

                if (isNumeric(userNumber) && !isStackOverflowable(userNumber)) {
                    double number = Double.parseDouble(userNumber);
                    int count = countDigits(number);
                    System.out.println(count);
                } else if (userNumber.equalsIgnoreCase("exit")) {
                    System.out.println("Counter stopped!");
                    break;
                } else {
                    System.out.println("Incorrect format or it'll throw StackOverflow");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private int countDigits(double userNumber) {

        System.out.println(Math.floor(userNumber));
        if (Math.floor(userNumber) != userNumber) {
            userNumber *= 10;
            countDigits(userNumber);
            return count;
        } else if (userNumber % dozens != userNumber) {
            dozens *= 10;
            count++;
            countDigits(userNumber);
            return count;
        } else {
            return dozens;
        }
    }


    private boolean isStackOverflowable (String str) {
        String regexAmount = ".{10,}";
        return str.matches(regexAmount);
    }


    private boolean isNumeric (String str) {
        String regexDecimal = "^-?\\d*\\.\\d+$";
        String regexInteger = "^-?\\d+$";
        String regexDouble = regexDecimal + "|" + regexInteger;
        return str.matches(regexDouble);
    }
}
