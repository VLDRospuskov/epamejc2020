package lessons.java.lesson21.example1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        assert value >= 100 : "not valid";
        System.out.println("Value " + value);
    }

}
