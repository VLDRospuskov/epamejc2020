package main.lesson1;

import java.util.Scanner;

public class HomeWork {


    private static String trafficLight(int minutes) {
        if (minutes >= 10) minutes %= 10;
        if (minutes >= 6) {
            return "RED";
        } else if (minutes >= 3) {
            return "YELLOW";
        } else if (minutes >= 0)
            return "GREEN";
        return ("Время не вернуть " + minutes);

       /* Создать "светофор", который выводит сигнал-цвет.
       Вы вводите время от 0-3 минуты - зеленый,
       4-5 минуты - желтый, 6-10 красный.
       Вводим цифру 0 до n, получаем результат.
       Работу программы сделать непрерывной, выход можно обработать.*/

    }

    public static void main(String[] args) {

        System.out.println("Введите минуты для рассчета света сигнала светофора или пустую строку для выхода из программы");
        Scanner scanner = new Scanner(System.in);
        String inputStream;
        int minutes;
        do {
            inputStream = scanner.nextLine();
            if (!inputStream.isBlank()) {
                try {
                    minutes = Integer.parseInt(inputStream);
                } catch (NumberFormatException e) {
                    System.out.println("Only numbers...");
                    System.out.println("Bye bye");
                    System.out.println("caught " + e.toString());
                    scanner.close();
                    break;

                }
                System.out.println(trafficLight(minutes));
            }

        } while (!inputStream.isBlank());

    }
}