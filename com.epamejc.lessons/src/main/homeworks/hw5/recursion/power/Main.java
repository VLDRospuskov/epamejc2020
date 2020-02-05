package main.homeworks.hw3.recursion.power;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println(Power.power(2, 8));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

}
