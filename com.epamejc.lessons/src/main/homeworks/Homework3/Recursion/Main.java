package main.homeworks.Homework3.Recursion;

public class Main {
    public static void main(String[] args) {
        RecursionTest app = new RecursionTest();
        for (int i = 0; i < 33; i++) {
            System.out.print(app.fibonacci(i) + " ");
        }
        System.out.println();
        System.out.println(app.pow(2, 3));
        System.out.println(app.pow(0.5, -2));
        System.out.println(app.numOfDigits(6));
        System.out.println(app.numOfDigits(1234567890));


    }
}
