package Homeworks.HW1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {

    public void start() {
        readInput();
    }

    private void readInput() {
        String line;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while ((line = br.readLine()) != null) {
                int minutes = prepareInput(line);
                if (minutes >= 0) {
                    System.out.println(getLight(minutes));
                } else {
                    System.out.println("Please provide correct input");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int prepareInput(String line) {
        if (isInteger(line)) {
            return Integer.parseInt(line);
        } else {
            return -1;
        }
    }

    public String getLight(int minutes) {
        while (minutes >= 10) {
            minutes = minutes - 10;
        }
        if (minutes < 4) {
            return "Light is GREEN";
        } else if (minutes < 6) {
            return "Light is YELLOW";
        } else {
            return "Light is RED";
        }
    }

    private boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
