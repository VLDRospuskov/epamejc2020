package homeworks.utility.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Helper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void showGreetingMessage() {
        System.out.println("Для выхода из программы введите \"exit\"");
    }

    public static String getUserInput(String message) {
        String input = null;
        System.out.print(message);

        try {
            input = reader.readLine();
            if (input.length() == 0
                    || input.trim().equalsIgnoreCase("выход")
                    || input.trim().equalsIgnoreCase("exit")
                    || input.trim().equalsIgnoreCase("q")) {
                input = "exit";
                closeReader();
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }

        return input;
    }

    public static int parseInt(String s) {
        int input;
        s = s.replaceAll(" ", "");

        try {
            input = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            s = getUserInput("Вы ввели не число! Попробуйте еще раз: ");
            input = parseInt(s);
        }

        return input;
    }

    public static void closeReader() {
        try {
            System.out.println("Поток успешно закрыт.");
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class HelperTestDrive {
    public static void main(String[] args) {
        boolean isRunning = true;
        while (isRunning) {
            String s = Helper.getUserInput("Введите строку: ");
            if (s.equals("exit")) {
                isRunning = false;
                continue;
            }
            System.out.println(s);

            String s2 = Helper.getUserInput("Введите число: ");
            if (s2.equals("exit")) {
                isRunning = false;
                continue;
            }
            int n = Helper.parseInt(s2);
            System.out.println(n);
            System.out.println("------------------------------");
        }
    }
}
