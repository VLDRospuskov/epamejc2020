package homeworks.hw1;

import java.util.Scanner;

class TrafficLight {
    String errMessage = "Wrong enter! Please enter positive number!";

    public int checkN(int n) { // приводим n к виду от 0 до 10
        if (n > 10) {
            while (n > 10) {
                n = n % 10;
            }
        }
        return n;
    }

    public String colorOut(int n) {
        if (n >= 0 && n <= 3) {
            return "Green";
        } else if (n >= 4 && n <= 5) {
            return "Yellow";
        } else if (n >= 6 && n <= 10) {
            return "Red";
        }
        return errMessage; // ошибка на случай отрицательных чисел

    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            int n = 0;
            System.out.print("Enter number(enter \"-1\" to exit): ");
            String str = sc.nextLine();
            try {
                n = checkN(Integer.parseInt(str));
            } catch (Exception e) {
                System.out.println(errMessage);
                continue;
            }
            if (n == -1) {
                break;
            }
            System.out.println("Traffic signal: " + colorOut(n));
        }
        sc.close();
    }
}
