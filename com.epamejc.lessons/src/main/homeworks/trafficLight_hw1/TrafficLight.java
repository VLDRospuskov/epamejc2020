package main.homeworks.trafficLight_hw1;

import java.util.Scanner;

public class TrafficLight {

    public void calculateColor() {
        System.out.println("Введите минуты для рассчета цвета сигнала светофора или пустую строку для выхода из программы");
        Scanner scanner = new Scanner(System.in);
        String inputStream;
        int minutes = 0;
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
                System.out.println(getColor(minutes));
            }
        } while (!inputStream.isEmpty());
    }

    private int getMinutes(int minutes) {
        if (minutes >= 10) {
            minutes %= 10;
        } else if (minutes < 0) {
            System.out.println("Only positive number");
            return Math.abs(minutes % 10);
        }
        return minutes;
    }

    private String getColor(int minutes) {
        minutes = getMinutes(minutes);
        if (minutes >= 6) {
            return Colors.Red + " color";
        } else if (minutes >= 3) {
            return Colors.Yellow + " color";
        } else {
            return Colors.Green + " color";
        }
    }
}