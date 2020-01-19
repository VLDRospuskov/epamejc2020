package main.lesson1;

import java.util.Scanner;

public class TrafficLight {

    private static String calculateColor(int minutes) {
        if (minutes >= 10) minutes %= 10;
        if (minutes >= 6) {
            return Colors.Red + " color";
        } else if (minutes >= 3) {
            return Colors.Yellow + " color";
        } else if (minutes >= 0)
            return Colors.Green + " color";
        return ("Время не вернуть " + minutes);
    }

    public void run() {
        System.out.println("Введите минуты для рассчета цвета сигнала светофора или пустую строку для выхода из программы");
        Scanner scanner = new Scanner(System.in);
        String inputStream;
        int minutes;
        do {
            inputStream = scanner.nextLine();
            if (!inputStream.isEmpty()) {
                try {
                    minutes = Integer.parseInt(inputStream);
                } catch (NumberFormatException e) {
                    System.out.println("Only numbers...");
                    System.out.println("Bye bye");
                    System.out.println("caught " + e.toString());
                    scanner.close();
                    break;
                }
                System.out.println(calculateColor(minutes));
            }
        } while (!inputStream.isEmpty());
    }
}