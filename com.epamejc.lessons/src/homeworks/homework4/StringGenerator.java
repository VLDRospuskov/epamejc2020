package homeworks.homework4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StringGenerator {
    private String savedInput = "";
    private StringChanger stringChanger;

    public StringGenerator(StringChanger st) {
        this.stringChanger = st;
    }

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter a text.\nYour text will be saved. If you want to delete saved text type D.");
        System.out.println("If you want to quit type Q.");

        while (true) {

            try {
                String userInput = reader.readLine();

                if (userInput.toLowerCase().equals("q")) {
                    reader.close();
                    break;
                } else if (userInput.toLowerCase().equals("d")) {
                    this.savedInput = "";
                    stringChanger.clearTemp();
                    continue;
                } else if (this.savedInput.equals("")) {
                    this.savedInput = userInput;
                    System.out.println("Enter 'even' or 'odd' or 'reverse' and see what happens.");
                    System.out.println("You can also enter a number or enter two numbers separated by space.");
                    continue;
                }

                if (tryParse(userInput)) {
                    int[] numArr = Arrays.stream(userInput.split(" ")).mapToInt(Integer::parseInt).toArray();
                    changeString(numArr);
                }

                changeString(userInput);

            } catch (IOException e) {
                System.out.println("Wrong entry. Try again.");
            }
        }
    }
    
    private void changeString(String userInput) {
        if (userInput.toLowerCase().equals("even")) {
            System.out.println(stringChanger.evenOrOddChars(this.savedInput, 1));
        } else if (userInput.toLowerCase().equals("odd")) {
            System.out.println(stringChanger.evenOrOddChars(this.savedInput, 0));
        } else if (userInput.toLowerCase().equals("reverse")) {
            System.out.println(stringChanger.reverse(this.savedInput));
        }
    }

    private void changeString(int[] numbs) {
        if (numbs.length > 1) {
            System.out.println(stringChanger.swapChars(this.savedInput, numbs[0], numbs[1]));
        } else {
            System.out.println(stringChanger.generateString(this.savedInput, numbs[0]));
        }
    }

    private boolean tryParse(String s) {
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

}
