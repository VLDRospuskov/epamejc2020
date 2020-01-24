package main.homeworks.hw1;

import java.util.Scanner;

class TrafficLight {
    final private String MESSAGE = "Enter number(enter \"-1\" to exit): ";
    final private String ERR_MESSAGE = "Wrong enter! Please enter positive number!";

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

    public void run() {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        try {
            while (loop) {
                int n = 0;
                System.out.print(MESSAGE);
                String str = sc.nextLine();
                try {
                    n = checkMinutes(Integer.parseInt(str));
                } catch (Exception e) {
                    System.out.println(ERR_MESSAGE);
                    continue;
                }
                if (n == -1) {
                    break;
                }
                System.out.println("Traffic signal: " + getColor(n));
            }
        } catch (Exception e){

        } finally {
            sc.close();
        }

    }

    /**
     * TRY {
     * WHILE
     *     TRY {
     *
     *     } Catch
     * } finally
     */
}
