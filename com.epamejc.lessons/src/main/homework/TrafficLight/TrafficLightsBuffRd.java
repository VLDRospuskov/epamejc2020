package homework.TrafficLight;

import java.io.BufferedReader;
import java.io.IOException;

public class TrafficLightsBuffRd {


    public static void colorCheck(BufferedReader reader) {
        double time;
        try {
            System.out.println("Введите время:");
            String inputTime = reader.readLine();
            time = Double.parseDouble(inputTime);
        } catch (IOException e) {
            System.out.println("Непредвиденная ошибка ввода-вывода");
            return;
        } catch (NumberFormatException e) {
            System.out.println("Введено некорректное значение");
            return;
        }
        if (time < 0 || time > 10) {
            System.exit(0);
        }
        if (time >= 0 && time < 3) {
            System.out.println("Сейчас горит зеленый");
        } else if (time >= 3 && time < 5) {
            System.out.println("Сейчас горит желтый");
        } else if (time >= 5 && time <= 10) {
            System.out.println("Сейчас горит красный");
        }
    }
}
