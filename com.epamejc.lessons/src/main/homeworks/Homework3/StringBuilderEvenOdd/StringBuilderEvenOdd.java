package main.homeworks.Homework3.StringBuilderEvenOdd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringBuilderEvenOdd {
    private String savedInput = "";

    public void run() {
        String input = "";

        System.out.println("Введите любую строку, exit, чтобы выйти, или new, чтобы ввести новую строку : ");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                input = reader.readLine();

                if (input.toLowerCase().equals("exit"))
                {
                    break;
                } else if (input.toLowerCase().equals("new")) {
                    savedInput = "";
                    System.out.println("Введите любую строку, exit, чтобы выйти, или new, " +
                            "чтобы ввести новую строку : ");
                    continue;
                } else if (savedInput.equals("")) {
                    savedInput = input;
                    System.out.println("Введите 'even' иши 'odd', чтобы получить новую строку, состоящую" +
                            "из четных, или нечетных элементов первой, либо new, или exit, чтобы " +
                            "ввести строку заново или выйти соответственно: ");
                    continue;
                }

                String result = evenOdd(input);
                System.out.println(result.equals("")? "Неверный ввод, попробуйте снова: " : result);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String evenOdd (String input) {
        StringBuilder result = new StringBuilder();
        if (input.equals("even")) {
            for (int i = 1; i < savedInput.length(); i += 2) {
                result.append(savedInput.charAt(i));
            }
        } else if (input.equals("odd")) {
            for (int i = 0; i < savedInput.length(); i += 2) {
                result.append(savedInput.charAt(i));
            }
        }
        return result.toString();
    }

}
