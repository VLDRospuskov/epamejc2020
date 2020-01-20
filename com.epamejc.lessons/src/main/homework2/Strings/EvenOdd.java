package main.homework2.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EvenOdd {
    public static void main(String[] args) throws IOException{
        EvenOdd evenOdd = new EvenOdd();
        evenOdd.go();
    }
    public void go() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String even = "even";

        String odd = "odd";

        String result = "";

        String start = "Введите строку";

        String choose = "Ввдите even or odd";

        System.out.println(start);
        String word = reader.readLine();

        System.out.println(choose);
        String choise = reader.readLine();

        for (int i = 0; i < word.length(); i++) {

            if (choise.equals(even) && i % 2 == 0) {
                result += word.charAt(i);

            } else if (choise.equals(odd) && i % 2 != 0) {
                result += word.charAt(i);
            }
        }

        System.out.println(result);
    }
}