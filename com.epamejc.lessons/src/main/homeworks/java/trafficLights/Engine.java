package homeworks.java.trafficLights;

import java.io.*;

//Создать "светофор", который выводит сигнал-цвет. Вы вводите время от 0-3 минуты - зеленый,
//4-5 минуты - желтый, 6-10 красный. Вводим цифру 0 до n, получаем результат. Работу программы
//сделать непрерывной, выход можно обработать.

class Engine {

    public void run() {


        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Type time in following format: \"m.s or m\", \nthere m - minutes from 0 to n, " +
                    "and s - seconds from 0 to 59 \nor word \"exit\" to quit the program");

            int exit;
            Lights lightsState;
            UserInputReader userInputReader = new UserInputReader();
            LightsLogic lightsLogic = new LightsLogic();

            do {
                String userInputString = userInputReader.readInput(reader);
                lightsState = lightsLogic.parseInputString((userInputString));
                exit = switchOutput(lightsState);

            } while (exit != 1);

        } catch (IOException e) {
            System.err.println("Something gone wrong with InputStream");
            e.printStackTrace();
        }
    }

    private int switchOutput(Lights state) {
        int indicator = 0;

        switch (state) {
            case GREEN:
                System.out.println("The traffic lights is Green");
                break;
            case YELLOW:
                System.out.println("The traffic lights is Yellow");
                break;
            case RED:
                System.out.println("The traffic lights is Red");
                break;
            case WRONG_INPUT:
                System.out.println("Wrong input! Try again.");
                break;
            case EXIT:
                System.out.println("Bye");
                indicator = 1;
                break;
        }
        return indicator;
    }
}




