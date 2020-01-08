package homework.homework2.indexStringGenerator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class UserController {

    void run() {

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {

                System.out.print("Enter string or 'exit': ");
                String userString = reader.readLine();

                if (userString.equalsIgnoreCase("exit")) {
                    System.out.println("Generator stopped!");
                    break;
                } else if (isIncorrectFormatOfString(userString)) {
                    System.out.println("String mustn't begin or end with space or tab symbol");
                    continue;
                }

                while (true) {

                    System.out.print("Enter index or 'next': ");
                    String userIndex = reader.readLine();

                    if (userIndex.equalsIgnoreCase("next")) {
                        break;
                    }

                    int badInput = -1;
                    int index = indexFilter(userIndex);

                    if (index != badInput && userString.length() > index) {
                        StringGenerator generator = new StringGenerator();
                        generator.generate(userString, index);
                    } else {
                        System.out.println("Index must be positive integer and less then string's length");
                    }

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private int indexFilter(String userIndex) {
        if (isPositiveDigit(userIndex)) {
            return Integer.parseInt(userIndex);
        } else {
            return -1;
        }
    }

    private boolean isIncorrectFormatOfString (String str) {
        return str.charAt(0) == ' ' || str.charAt(str.length()-1) == ' ' || str.substring(0,1).equals("\t") || str.substring(str.length()-1).equals("\t");
    }

    private boolean isPositiveDigit (String str) {
        String regexInteger = "^\\d+$";
        return str.matches(regexInteger);
    }
}
