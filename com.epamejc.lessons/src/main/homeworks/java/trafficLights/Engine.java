package homeworks.java.trafficLights;

import java.io.*;
import java.math.*;

//Создать "светофор", который выводит сигнал-цвет. Вы вводите время от 0-3 минуты - зеленый,
//4-5 минуты - желтый, 6-10 красный. Вводим цифру 0 до n, получаем результат. Работу программы
//сделать непрерывной, выход можно обработать.

class Engine {

    public void run(InputStream in, PrintStream out) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {

            Lights state;
            InputProcessor input = new InputProcessor();

            out.println("Type time in following format: \"m.s or m\", \nthere m - minutes from 0 to n, " +
                    "and s - seconds from 0 to 59 \nor word \"exit\" to quit the program");

            do {
                state = input.readInput(reader);

                switch (state) {
                    case GREEN:
                        out.println("The traffic lights is Green");
                        break;
                    case YELLOW:
                        out.println("The traffic lights is Yellow");
                        break;
                    case RED:
                        out.println("The traffic lights is Red");
                        break;
                    case WRONG_INPUT:
                        out.println("Wrong input! Try again.");
                        break;
                    case EXCEPTION:
                        out.println("Program closed with an error 1");
                        break;
                    case EXIT:
                        out.println("Bye");
                        break;
                }

            } while (state != Lights.EXIT && state != Lights.EXCEPTION);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



