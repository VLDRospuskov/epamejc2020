package main.java.homework.strings.strings4;

import java.util.Scanner;

public class WordReverser {

     public void run () {
         String s = input();
         reverse(s);
     }

  private void reverse (String str) {

        for (String part : str.split(" ")) {
            System.out.print(new StringBuilder(part).reverse().toString());
            System.out.print(" ");
    }
    }
    private String input () {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
