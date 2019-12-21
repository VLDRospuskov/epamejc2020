/*Создать "светофор", который выводит сигнал-цвет. Вы вводите время от 0-3 минуты - зеленый,
4-5 минуты - желтый, 6-10 красный. Вводим цифру 0 до n, получаем результат. Работу программы
сделать непрерывной, выход можно обработать.*/
package main.homework.hw1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLights {

    private static final String INTRO = "Please, type in number in range from 0 to 10. For exit - \"exit\"";
    private static final String EXIT = "exit";
    private String userInput;

    public static void main(String[] args) {
        TrafficLights trafficLights = new TrafficLights();
        trafficLights.start();
    }

    public void start() {
        System.out.println(INTRO);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean needExit = true;
        while (needExit)
            try {
                userInput = br.readLine();
                if (!userInput.equals(EXIT)) {
                    defineSignal();
                } else needExit = false;

                } catch (IOException ex) {
                ex.printStackTrace();
                }
    }

    private void defineSignal() {
        int num;
        try {
            num = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            System.out.println("numbers must be integers");
            return;
        }

        if (num >= 0 && num <= 3) System.out.println("green");
        else if (num > 3 && num <= 5) System.out.println("yellow");
        else if (num > 5 && num <= 10) System.out.println("red");
        else System.out.println("range must be from 0 to 10");
    }
}


