package homework.homework5.dozensCounterHard;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Counter {

    private int dozens = 10;
    private int count = 1;

    void count () {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {

                dozens = 10;
                count = 1;

                System.out.print("Enter number or 'exit': ");
                String userNumber = reader.readLine();

                if (isNumeric(userNumber) && !isStackOverflowAble(userNumber)) {
                    double number = Double.parseDouble(userNumber);
                    count = countDigits(number);
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

        if (Math.floor(userNumber) != userNumber) {
            if (Math.floor(userNumber) == 0) {
                count ++;
            }
            userNumber *= 10;
            countDigits(userNumber);
            return count;
        } else if (userNumber % dozens != userNumber) {
            dozens *= 10;
            count++;
            countDigits(userNumber);
            return count;
        } else {
            return count;
        }
    }


    private boolean isStackOverflowAble (String str) {
        String regexAmount = ".{10,}";
        String regexWeird1_1 = "^.\\.001+";
        String regexWeird1_2 = "^.\\.0011+[0-3]";
        String regexWeird1 = regexWeird1_1 + "|" + regexWeird1_2; // some like 1.001 or 4.00111 but not 1.0012
        String regexWeird2_1 = "^10[^0-2]\\.01+";
        String regexWeird2_2 = "^12[^89]\\.01+";
        String regexWeird2_3 = "^11.\\.01+";
        String regexWeird2_4 = "^12[^89]\\.01[0-4]";
        String regexWeird2 = regexWeird2_1 + "|" + regexWeird2_2 + "|" + regexWeird2_3 + "|" + regexWeird2_4;
       return str.matches(regexAmount + "|" + regexWeird1 + "|" + regexWeird2);
    }


    private boolean isNumeric (String str) {
        String regexDecimal = "^-?\\d*\\.\\d+$";
        String regexInteger = "^-?\\d+$";
        String regexDouble = regexDecimal + "|" + regexInteger;
        return str.matches(regexDouble);
    }
}
