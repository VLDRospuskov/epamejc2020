package main.homeworks.hw5.recursion.countnumbers;

public class Main {

    public static void main(String[] args) {

        try {
            System.out.println(Counter.counterOfNumbers(564865487945L));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

    }

}
