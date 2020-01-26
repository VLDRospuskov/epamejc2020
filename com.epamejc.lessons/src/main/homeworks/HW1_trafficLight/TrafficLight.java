package main.homeworks.HW1_trafficLight;

import java.util.Scanner;

/**
 * Класс для реализации логики работы светофора
 */
public class TrafficLight {
    private final String SystemMessage = "Enter the number of seconds. To exit, enter an empty string: ";

    public void run() {
        Scanner scan = new Scanner(System.in);
        System.out.print(SystemMessage);
        String inputString = scan.nextLine();

        while (!inputString.isEmpty()) {
            try {
                int secQuantity = Integer.parseInt(inputString);
                String response = DefineTrafficLightSignal(secQuantity);
                System.out.println(response);
                System.out.print(SystemMessage);
                inputString = scan.nextLine();
            } catch (Exception exc) {
                System.out.println("ПTraffic light is broken: " + exc.toString());
                break;
            }
        }
        scan.close(); //Здесь закрываем поток в случае пользовательского выхода или исключения
        System.out.println("Program ends");
    }

    /**
     * Метод для определения цвета сигнала светофора
     * @param num время с начала работы светофора, сек
     * @return цвет сигнала
     */
    private static String DefineTrafficLightSignal(int num) {
        num = num % 600; //контур на 10 минут

        if (num >= 0 && num <= 180) {
            return TrafficLightColors.Green + " color";
        } else if (num > 180 && num <= 300) {
            return TrafficLightColors.Yellow + " color";
        } else if (num > 300) {
            return TrafficLightColors.Red + " color";
        } else {
            return "Traffic light isn't working yet";
        }
    }
}
