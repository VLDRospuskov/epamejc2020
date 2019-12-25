package main.lessons.lesson4.recursion;

public class Example1 {

    public static void main(String[] args) {
        f(1);
    }

    public static void f(int x) {
        if (x < 15) {
            f(2 * x);
        }
        System.out.print(" " + x);
    }

}
