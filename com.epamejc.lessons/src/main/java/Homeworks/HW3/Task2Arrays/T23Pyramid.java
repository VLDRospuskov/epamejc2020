package Homeworks.HW3.Task2Arrays;

public class T23Pyramid {
    public void start(int len) {
        while (len > 0) {
            for (int i = 0; i < len; i++) {
                System.out.print("X");
            }
            System.out.println(" ");
            len--;
        }
    }
}
