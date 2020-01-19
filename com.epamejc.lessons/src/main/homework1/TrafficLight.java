package main.homework1;

import java.io.*;

public class TrafficLight {
    static {
        System.out.println("Enter the amount of minutes (it could be integer or float)." + "\n" +
                "To end the program - enter \"exit\".");
    }

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    protected void start() {
        try {
            while (true) {
                String time = reader.readLine();
                if (!time.equals("exit")) {
                    chooseColor(time);
                } else {
                    reader.close();
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }


    private void chooseColor(String time) {
        try {
            double minute = Double.parseDouble(time);
            if (minute % 10 <= 3) {
                System.out.println("Green signal");
            } else if (minute % 10 > 3 & minute % 10 <= 5) {
                System.out.println("Yellow signal");
            } else {
                System.out.println("Red signal");
            }
        } catch (NumberFormatException e) {
            System.out.println("Incorrect input.Try again.");
        }
    }
}

