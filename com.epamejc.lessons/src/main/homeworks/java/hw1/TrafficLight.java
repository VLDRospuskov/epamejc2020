package homeworks.java.hw1;

import java.util.Scanner;

class TrafficLight {

    final private String MESSAGE = "Enter number(enter \"-1\" to exit): ";
    final private String ERR_MESSAGE = "Wrong enter! Please enter positive number between 0 and " + Integer.MAX_VALUE + "!";

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

    public int checkMinutes(int n) {
        if (n > 10) {
            while (n > 10) {
                n = n % 10;
            }
        }

        return n;
    }

    public String getColor(int n) {
        if (n >= 0 && n <= 3) {
            return "Green";
        } else if (n >= 4 && n <= 5) {
            return "Yellow";
        } else if (n >= 6 && n <= 10) {
            return "Red";
        }

        return ERR_MESSAGE;
    }

}
