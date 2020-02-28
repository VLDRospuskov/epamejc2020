package homeworks.homework2.recursion;

import homeworks.InputReader;
import homeworks.homework2.recursion.task4_1.Fibonacci;
import homeworks.homework2.recursion.task4_2.Power;
import homeworks.homework2.recursion.task4_3.Digits;

public class RunRecursionTasks {

    public static void main(String[] args) {
        System.out.println("Input task number from 1 to 3");
        String task = InputReader.nextString();
        int number;
        switch (task) {
            case "1":
                System.out.println("Input n to get N-th number in fibonacci");
                number = InputReader.nextInt();
                System.out.println(Fibonacci.calculateFibonacci(number));
                break;
            case "2":
                System.out.println("Input number");
                number = InputReader.nextInt();
                System.out.println("Input pow");
                int pow = InputReader.nextInt();
                System.out.println(Power.calcPow(number, pow));
                break;
            case "3":
                System.out.println("Input number to calculate ammount of Digits");
                number = InputReader.nextInt();
                System.out.println(Digits.getAmountOfDigits(number));
                break;
        }
    }

}
