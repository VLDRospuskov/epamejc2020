package homeworks.homework4.reverseWords;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class StringReverser {

    void run () {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {

                System.out.print("Enter string or 'exit': ");
                String userString = reader.readLine();

                if (userString.equalsIgnoreCase("exit")) {
                    System.out.println("Reverser stopped!");
                    break;
                } else if (isCorrectFormatOfString(userString)) {
                    String reversedString = reverse(userString);
                    System.out.println(reversedString);
                } else {
                    System.out.println("Incorrect format");
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private String reverse (String userString) {

        String[] strings = userString.split(" ");
        String result = "";

        for (int i=0; i<strings.length; i++) {
            for (int j=strings[i].length()-1; j>=0; j--) {
                result += strings[i].charAt(j);
            }
            if (strings.length > 1 && i != strings.length-1) {
                result += " ";
            }
        }
        return result;
    }


    private boolean isCorrectFormatOfString (String str) {
        return str.length() > 1 && str.charAt(0) != ' ' && !str.substring(0,1).equals("\t");
    }

}
