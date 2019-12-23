package main.Homeworks.HW1;

import java.util.Scanner;

public class TrafficLight
{
    public static void main(String[] args)
    {
        String SystemMessage = "Введите количество секунд. Для завершения работы введите пустую строку: ";
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
                System.out.println("Похоже, вы сломали светофор: " + exc.toString());
                break;
            }
        }
        System.out.println("Программа завершается");
    }

    private static String DefineTrafficLightSignal(int num)
    {
        String result;
        num = num % 600; //контур на 10 минут

        if (num >= 0 && num <= 180) result = "Зеленый сигнал";
        else if (num > 180 && num <= 300) result = "Желтый сигнал";
        else if (num > 300) result = "Красный сигнал";
        else result = "Светофор еще не включился";

        return result;
    }
}
