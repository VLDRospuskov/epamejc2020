package homeworks.hw1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/*
Светофор, выводящий сигнал-цвет. Input: цифра-время от 0 до n время
Output:  0-3 минуты => зеленый, 4-5 минуты => желтый, 6-10 => красный.
Работу программы сделать непрерывной, выход можно обработать.
 */
public class TrafficLights {

    public static Double getTime(String inputString) {
        Double d = new Double(null);
        try {
            d = Double.parseDouble(inputString);
        } catch (NumberFormatException e) {
            System.out.println("You have to enter the number");
        }
        return d;
    }

    public static String getColor(Double time) {
        time = time % 10;
        if ((time >= 0) && (time <= 3)) {
            return "green";
        }
        if ((time >= 4) && (time <= 5)) {
            return "yellow";
        }
        if ((time >= 6) && (time <= 10)) {
            return "red";
        }
        return " ";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean exitCondition = true;

        while (exitCondition) {
            System.out.print("Enter the number (type 'exit' to exit): ");
            String inputString = br.readLine();

            if (inputString.equalsIgnoreCase("exit")) {
                br.close();
                exitCondition = false;
                continue;
            }

            Double time = getTime(inputString);
            String color;
            if (time != null) color = getColor(time);
            else {
                System.out.println("_____________");
                continue;
            }

            System.out.println("The color is " + color);
            System.out.println("_____________");
        }
    }
}
