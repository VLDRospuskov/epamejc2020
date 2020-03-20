package homeworks.homework04;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        RecursionTasks recursionTasks = new RecursionTasks();

        System.out.print("Enter number of fibonacci number: ");
        int n = Integer.parseInt(reader.readLine());
        System.out.println("N-th fibonacci number is " + recursionTasks.fibonacci(n));

        System.out.print("Enter value for exponentiation: ");
        int value = Integer.parseInt(reader.readLine());
        System.out.print("Enter power: ");
        int power = Integer.parseInt(reader.readLine());
        System.out.println(power + " power of " + value + " is " + recursionTasks.power(value, power));

        System.out.print("Enter value to count digits: ");
        int digits = Integer.parseInt(reader.readLine());
        System.out.println(digits + " has " + recursionTasks.numberOfDigits(digits) + " digits.");
    }

}
