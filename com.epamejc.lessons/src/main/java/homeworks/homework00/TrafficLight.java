package homeworks.homework00;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TrafficLight {

    public void launch() {
        System.out.println("Введите количество минут." + "\n" +
                "Для завершения - введите 0");

        int time;
        while ((time = readTimeWithBufReader()) != 0) {
            System.out.println(getTrafficLightColorFromMinute(time));
        }
    }

    @SneakyThrows
    private int readTimeWithBufReader() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String value;
        int time;

        value = reader.readLine();
        time = Integer.parseInt(value);

        return time;
    }

    public String getTrafficLightColorFromMinute(Integer minute) {
        if (minute >= 1 && minute <= 4) {
            return "Green";
        }
        if (minute >= 5 && minute <= 7) {
            return "Yellow";
        }
        if (minute >= 8 && minute <= 10) {
            return "Red";
        }
        return "It is broken!";
    }

}

