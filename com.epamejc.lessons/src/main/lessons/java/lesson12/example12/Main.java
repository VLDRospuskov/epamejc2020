package lessons.java.lesson12.example12;

import lombok.SneakyThrows;

import java.io.FileReader;
import java.util.Scanner;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        FileReader fr = new FileReader("file 1.txt");
        Scanner scan = new Scanner(fr);

        while (scan.hasNext()) {
            if (scan.hasNextInt())
                System.out.println(scan.nextInt() + ":int");
            else if (scan.hasNextDouble())
                System.out.println(scan.nextDouble() + ":double");
            else if (scan.hasNextBoolean())
                System.out.println(scan.nextBoolean() + ":boolean");
            else
                System.out.println(scan.next() + ":String");

        }
    }
}
