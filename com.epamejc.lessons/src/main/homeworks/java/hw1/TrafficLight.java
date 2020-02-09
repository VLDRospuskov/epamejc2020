package homeworks.java.hw1;

import java.util.Scanner;

class TrafficLight {

    final private String MESSAGE = "Enter number(enter \"-1\" to exit): ";
    final private String ERR_MESSAGE = "Wrong enter! Please enter positive number!";
    boolean isError = false;
    Scanner sc;

    public void run() {
        boolean loop = true;

        try {
            while (loop) {
                sc = new Scanner(System.in);
                int n = scan(sc);

                if (isError) {
                    isError = false;
                    continue;
                } else if (n == -1) {
                    break;
                }

                System.out.println("Traffic signal: " + getColor(n));
            }

        } catch (Exception e){
            System.out.println(ERR_MESSAGE);
        } finally {
            sc.close();
        }

    }

    public int scan(Scanner sc) {
        int n = 0;
        String str = "";

        try {
            System.out.print(MESSAGE);
            str = sc.nextLine();
            n = checkMinutes(Integer.parseInt(str));
        } catch (Exception e) {
            System.out.println(ERR_MESSAGE);
            isError = true;
        }
        return n;
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
