package homework.homework5.dozensCounterLite;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Counter {

    int index = 0;
    int count = 0;

    void count () {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {

                System.out.print("Enter number or 'exit': ");
                String userNumber = reader.readLine();

                if (isNumeric(userNumber)) {
                    index = 0;
                    count = 0;
                    count = countDigits(userNumber);
                    System.out.println(count);
                } else if (userNumber.equalsIgnoreCase("exit")) {
                    System.out.println("Counter stopped!");
                    break;
                } else {
                    System.out.println("Incorrect format");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private int countDigits(String userNumber) {
        if (index < userNumber.length() && Character.isDigit(userNumber.charAt(index))) {
            index++;
            count++;
            countDigits(userNumber);
        } else if (index < userNumber.length()) {
            index++;
            countDigits(userNumber);
        }
        return count;
    }

    private boolean isNumeric (String str) {
        String regexDecimal = "^-?\\d*\\.\\d+$";
        String regexInteger = "^-?\\d+$";
        String regexDouble = regexDecimal + "|" + regexInteger;
        return str.matches(regexDouble);
    }
}
