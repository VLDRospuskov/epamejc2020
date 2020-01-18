package main.HM0_TrafficLight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {

    {
        System.out.println("Введите количество минут (можно не целое)." + "\n" +
                "Когда надоест - введите exit");
    }

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String time;

    void start() {
        try {
            while (true) {
                time = reader.readLine();
                if (!time.equals("exit")) {
                    chooseColor(time);
                } else {
                    reader.close();
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    private void chooseColor(String time) {
        try {
            double minute = Double.parseDouble(time);
            if (minute % 10 <= 3) {
                System.out.println("Зеленый сигнал");
            } else if (minute % 10 > 3 & minute % 10 <= 5) {
                System.out.println("Желтый сигнал");
            } else {
                System.out.println("Красный сигнал");
            }
        } catch (NumberFormatException e) {
            System.out.println("Кажется, это не минуты:(");
        }
    }
}

