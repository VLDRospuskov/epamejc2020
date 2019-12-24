package main.homeworks.homework1;

import java.io.*;
import java.math.*;

//Создать "светофор", который выводит сигнал-цвет. Вы вводите время от 0-3 минуты - зеленый,
//4-5 минуты - желтый, 6-10 красный. Вводим цифру 0 до n, получаем результат. Работу программы
//сделать непрерывной, выход можно обработать.

class TrafficLights {

    void run() {

        boolean isDone;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Type time in following format: \"m.s or m\", \nthere m - minutes from 0 to n, " +
                    "and s - seconds from 0 to 59 \nor word \"exit\" to quit the program");

            do {
                isDone = mainLoopStart(reader);
            } while (!isDone);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private boolean mainLoopStart(BufferedReader reader) throws IOException {

        String inp = reader.readLine();
        double result;

        if (inp.equals("exit")) {
            return true;
        } else {
            try {
                result = Double.parseDouble(inp);
                result = new BigDecimal(result).setScale(3, RoundingMode.DOWN).doubleValue();
                inputCheck(result);
            } catch (NumberFormatException e) {
                System.out.println("Use numbers, or word exit.");
            }
        }
        return false;
    }


    private void inputCheck(double num) {

        String wrongInput = "Wrong input, try again!";
        num %= 10;

        if (num - (int)num >= 0.599) {
            System.out.println(wrongInput);
        } else if (num >= 0 && num < 3) {
            System.out.println(Lights.GREEN);
        } else if (num >= 3 && num < 5) {
            System.out.println(Lights.YELLOW);
        } else if (num >= 5 && num < 10) {
            System.out.println(Lights.RED);
        } else {
            System.out.println(wrongInput);
        }

    }
}

