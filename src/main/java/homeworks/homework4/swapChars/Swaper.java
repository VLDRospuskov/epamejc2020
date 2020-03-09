package homeworks.homework4.swapChars;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Swaper {

    void run () {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {

                System.out.print("Enter string or \"exit\": ");
                String userString = reader.readLine();

                if (userString.equalsIgnoreCase("exit")) {
                    System.out.println("Swapper stopped!");
                    break;
                }

                while (true) {

                    System.out.print("Enter \"index1 index2\" or \"next\": ");
                    String userIndexes = reader.readLine();

                    if (isPositiveDigits(userIndexes)) {

                       handleInput(userString, userIndexes);

                    } else if (userIndexes.equalsIgnoreCase("next")) {
                        break;
                    } else {
                        System.out.println("Indexes must be positive integers");
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void handleInput (String userString, String userIndexes) {
        String[] indexes = userIndexes.split(" ", 2);
        int index1 = Integer.parseInt(indexes[0]);
        int index2 = Integer.parseInt(indexes[1]);

        if (index1 < userString.length() && index2 < userString.length() && index1 != index2) {
            String swapedString = swap(userString, index1, index2);
            System.out.println(swapedString);
        } else {
            System.out.println("Indexes must be different and less then string's length");
        }
    }

    private String swap (String userString, int index1, int index2) {

        StringBuilder stringBuilder = new StringBuilder(userString);
        stringBuilder.setCharAt(index1, userString.charAt(index2));
        stringBuilder.setCharAt(index2, userString.charAt(index1));

        return stringBuilder.toString();
    }

    private boolean isPositiveDigits (String str) {
        String regexInteger = "^\\d+\\s\\d+$";
        return str.matches(regexInteger);
    }

}
