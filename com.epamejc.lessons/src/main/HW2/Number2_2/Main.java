package main.HW2.Number2_2;

/*. Сгенерировать массив массивов указав размерность, заполнить его случайными символами. Написать 2 стратегии,
 которые будут формировать строку на основе данного массива.
 Стратегия А - работает по принципу *_*_*, а стратегия B - работает по принципу _*_*_ .*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String strA = "A";
        String strB = "B";


        String strategy = reader("Write strategy A or B: ");

        if(strategy.equals(strA)) {
            new Array(new Scanner(System.in)).runA();
        }else if (strategy.equals(strB)){
            new Array(new Scanner(System.in)).runB();
        } else {
            System.out.println("Wrong strategy! Please try again.");
        }
    }

    public static String reader(String s){
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        String srt = null;
        try {
            System.out.println(s);
            srt = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return srt;
    }
}
