package main.HM0_TrafficLight;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        trafficLight.launch();
    }

    { // class initializer
        System.out.println("Введите количество минут." + "\n" +
                "Для завершения - введите 0");
    }


    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    //String time;
    Double time = 11.;
    public void launch() {
        readTime();
        while (time != 0) {
            System.out.println(getSignal(time));
            readTime();
        }
    }

    public void readTime() { // time = readTime(); OR readTime(); - какой лучше делать тип возвр значения?
        String value = "";
        try {
            value = reader.readLine();
        } catch (IOException e) {
            System.out.println("Some error!");
        }
        try {
            time = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            //e.printStackTrace();
            System.out.println("ЭТО НЕ ЧИСЛО!!!!!");
        }
    }

    private String getSignal (Double minute) {
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

