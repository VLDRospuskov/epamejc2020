package homeworks.java.hw1;

import java.util.Scanner;

class TrafficLight {

    final private String MESSAGE = "Enter number(enter \"-1\" to exit): ";
    final private String ERR_MESSAGE = "Wrong enter! Please enter positive number between 0 and "
            + Integer.MAX_VALUE + "!";

    public void run() {
        boolean loop = true;
        while (loop) {
            int minutes = checkMinutes(scanMinutes());
            if (minutes == -1) {
                break;
            }
            System.out.println("Traffic signal: " + getColor(minutes));
        }
    }

    public int scanMinutes() {
        Scanner sc;
        int minutes = 0;
        boolean isError = true;
        while (isError) {
            sc = new Scanner(System.in);
            try {
                isError = false;
                System.out.print(MESSAGE);
                minutes = sc.nextInt();
            } catch (Exception e) {
                System.out.println(ERR_MESSAGE);
                isError = true;
            }
        }
        return minutes;
    }

    public int checkMinutes(int minutes) {
        if (minutes > 10) {
            while (minutes > 10) {
                minutes %= 10;
            }
        }

        return minutes;
    }

    public String getColor(int minutes) {
        if (minutes >= 0 && minutes <= 3) {
            return "Green";
        } else if (minutes >= 4 && minutes <= 5) {
            return "Yellow";
        } else if (minutes >= 6 && minutes <= 10) {
            return "Red";
        }

        return ERR_MESSAGE;
    }

}
