package homework.homework5;

import homework.homework5.recursion.DigitsCounter;
import homework.homework5.recursion.Fibonacci;
import homework.homework5.recursion.Pow;

public class Main {
    public static void main(String[] args) {
        System.out.println(Fibonacci.getFibonacci(4));
        System.out.println(Pow.getPow(4, 3));
        System.out.println(DigitsCounter.countDigits(-111));
    }
}
