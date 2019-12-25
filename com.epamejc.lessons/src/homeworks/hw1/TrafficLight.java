package homeworks.hw1;

import java.util.Scanner;

class TrafficLight {
    public int readNumber() {
        int n = 0;
        System.out.print("Enter number(enter \"-1\" to exit): ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        try {
            n = Integer.parseInt(str);
        } catch (Exception e) {
            System.out.println("Wrong enter! Please enter number!");
        } finally {
            //sc.close();
        }
        return n;
    }

    public int checkN (int n){
        if (n > 10) {
            while (n > 10) {
                n = n % 10;
            }
        }
        return n;
    }

    public String outColor (int n) {
        if (n >= 0 && n <= 3) {
            return "Green";
        } else if (n >= 4 && n <= 5) {
            return "Yellow";
        } else {
            return "Red";
        }
    }

    public void run() {
        boolean loop = true;
        while (loop) {
            int n = checkN(readNumber());
            if (n == -1) {
                break;
            }
            System.out.println("Traffic signal: " + outColor(n));
        }
    }
}
