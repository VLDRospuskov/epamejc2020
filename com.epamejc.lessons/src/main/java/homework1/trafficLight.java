package homework1;

import java.util.Scanner;

public class trafficLight {
    private String sec;
    private boolean exit = false;

    public void run() {
        while (!exit) {
            System.out.print("Enter sec (-1 to exit): ");
            getSec();
            System.out.println();
            if (Integer.parseInt(sec) == (-1)) {
                exit = true;
            }
            System.out.print(selectColor(sec));
        }
    }

    private void getSec() {
        sec = new Scanner(System.in).nextLine();
    }

    private static Boolean isNum(String str) {
        return str.matches("[-+]?\\d+");
    }

    private static String selectColor(String min) {

        if (isNum(min)) {
            if (Integer.parseInt(min) >= 0 && Integer.parseInt(min) < 4) {
                return ("Green");

            } else if (Integer.parseInt(min) >= 4 && Integer.parseInt(min) < 6) {
                return ("Yellow");

            } else if (Integer.parseInt(min) >= 6 && Integer.parseInt(min) <= 10) {
                return ("Red");

            } else {
                return ("Error");

            }
        } else {
            return ("Error");
        }
    }
}
