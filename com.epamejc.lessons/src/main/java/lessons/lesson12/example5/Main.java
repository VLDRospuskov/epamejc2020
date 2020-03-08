package lessons.lesson12.example5;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InputStream in = System.in;
        PrintStream err = System.err;
        PrintStream out = System.out;
        Scanner scanner = new Scanner("hello");
        System.out.println(scanner.nextLine());
    }

}
