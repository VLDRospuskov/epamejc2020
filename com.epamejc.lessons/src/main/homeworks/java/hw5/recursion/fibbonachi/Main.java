package main.homeworks.java.recursion.fibbonachi;

import static main.homeworks.java.recursion.fibbonachi.Fibbonachi.fibbonachi;

public class Main {

    public static void main(String[] args) {

        try {
            System.out.println(fibbonachi(16));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

    }

}
