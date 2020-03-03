package homeworks.homework00;

import lombok.SneakyThrows;

import java.io.*;

public class TrafficLight {

    public void launch() {
        //TODO нужно ли тестировать методы, которые сделаны public, только чтобы к ним был доступ из лаунчера (мейна)?
        System.out.println("Введите количество минут." + "\n" +
                "Для завершения - введите 0");

        int time;
        while ((time = readTimeWithBufReader()) != 0) {
            //TODO Можно ли так написать аргумент? Если нет, то как передавать значение в метод ниже?
            System.out.println(getTrafficLightColorFromMinute(time));
        }
    }

    @SneakyThrows
    private int readTimeWithBufReader() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //TODO как сделать, чтобы ридер не создавался каждый раз новый? Где именно его создать и передавать?
        String value;
        int time = 0;

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

