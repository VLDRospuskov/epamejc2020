package homeworks.homework1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheTrafficLights {

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Welcome to The Traffic Light \nPlease, enter a number. \nIf you want to quit, enter Q.");

        while (true) {

            try {
                String userInput = reader.readLine();

                if (userInput.toLowerCase().equals("q")) {
                    reader.close();
                    break;
                }

                if (tryParse(userInput)) {
                    int number = Integer.parseInt(userInput);
                    checkTheLight(number);
                }
            } catch (IOException e) {
                System.out.println("Wrong entry! You should enter a positive number!");
            }
        }
    }

    private void checkTheLight(int number) {
        if (number > 10) {
            number = number % 10;
        }

        String s = "";

        if (number >= 0 && number <= 3) {
            s = Colors.GREEN.toString();
        } else if (number >= 4 && number <= 5) {
            s = Colors.YELLOW.toString();
        } else {
            s = Colors.RED.toString();
        }

        System.out.println("Signal is " + s);
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
