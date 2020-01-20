package main.HW2.Number4_2;

/*Написать программу которая умеет вовзодить в степени*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
    public static void main(String[] args) {

        BufferedReader reader1 = new BufferedReader( new InputStreamReader(System.in));
        String numb1 = null;
        try {
            System.out.println("Write your number: ");
            numb1 = reader1.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int num1 = Integer.parseInt(numb1);

        BufferedReader reader2 = new BufferedReader( new InputStreamReader(System.in));
        String numb2 = null;
        try {
            System.out.println("Write he power: ");
            numb2 = reader2.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int num2 = Integer.parseInt(numb2);
        System.out.print("Result: ");
        System.out.println(pow(num1, num2));

    }
    static int pow(int number, int pow) {
        if (pow == 0) {
            return 1;
        }
        if (pow == 1) {
            return number;
        }
        return number * pow(number, pow - 1);
    }

}

