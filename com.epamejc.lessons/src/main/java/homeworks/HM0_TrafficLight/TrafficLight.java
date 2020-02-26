package homeworks.HM0_TrafficLight;

import java.io.*;
import java.util.Arrays;

public class TrafficLight {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private Integer time = 11;

    public void setReader(InputStream inputStream){
        reader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public void launch() {
        System.out.println("Введите количество минут." + "\n" +
                "Для завершения - введите 0");

        readTime();
        while (time != 0) {
            System.out.println(getSignal(time));
            readTime();
        }
    }

    private void readTime() { // time = readTime(); OR readTime(); - какой лучше делать тип возвр значения?
        String value = "";
        try {
            value = reader.readLine();
            time = Integer.parseInt(value);
        } catch (IOException e) {
            System.out.println("Some error!");
        } catch (NumberFormatException e) {
            System.out.println("ЭТО НЕ ЧИСЛО!!!!!");
        }
    }

    private String getSignal (Integer minute) {
        if (minute>0 && minute<=4) {
            return "Green";
        }
        if (minute>=5 && minute<=7) {
            return "Yellow";
        }
        if (minute>=8 && minute<=10) {
            return "Red";
        }
        return "It is broken!";
    }
}

