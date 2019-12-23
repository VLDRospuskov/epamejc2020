package main.lesson1;
/*Создать "светофор", который выводит сигнал-цвет. Вы вводите время от 0-3 минуты - зеленый,
4-5 минуты - желтый, 6-10 красный. Вводим цифру 0 до n, получаем результат. Работу программы
сделать непрерывной, выход можно обработать.*/

import java.io.*;

public class Kofanov_HW1 {
    public static void main(String[] args) throws IOException {
        Object object;
        System.out.println("Введите количество минут (можно не целое)." + "\n" +
                "Когда надоест - введите exit");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String time;

        while (true) {
            time = reader.readLine();
            if (!time.equals("exit")) {
                trafficLight(time);
            } else {
                reader.close();
                break;
            }
        }
    }

    static void trafficLight(String time) {
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
