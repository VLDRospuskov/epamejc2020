package homeworks.homework1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {

    private Double time;
    public static boolean isRun = true;

    public void readTime() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Write a number:");
            String inputLine = br.readLine();
            //System.out.println(inputLine);
            try {
                this.time = Double.parseDouble(inputLine);
            } catch (NumberFormatException e) {
                System.err.println("You wrote not a number. Better luck next time!");
                isRun = false;
                e.printStackTrace();
            }

            if (!isRun) {
                br.close();
            }

        } catch (IOException e) {
            System.out.println("Something went wrong!");
            isRun = false;
            e.printStackTrace();
        }
    }

    public void conditionCheck() {

        if (time >= 0 && time < 4) {
            System.out.println("Green");
        } else if (time >= 4 && time < 6) {
            System.out.println("Yellow");
        } else if (time >= 6 && time < 11) {
            System.out.println("Red");
        } else {
            System.out.println("Wrong number. Try again.");
        }
    }

    public void trafficRun() {
        while (isRun) {

            this.readTime();
            this.conditionCheck();
        }
    }
}
