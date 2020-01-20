package main.HW2.Number4_3;

/*Посчитать количество чисел*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        String str = null;
        try {
            System.out.println("Write your number: ");
            str = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int count = Integer.parseInt(str);

        System.out.print("Result: ");
        System.out.print(countOfNumbers(count));
    }

    static int countOfNumbers(int count){
        if (count/10!=0)
            return 1 + countOfNumbers(count / 10);
        else
            return 1;
    }
}
