package main.homeworks.homework2.strings.exchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ExchangeElement {
    private String input;
    private int firstIndex;
    private int secondIndex;


    public void run() {
        inputString();
        inputIndexes();
        exchange();
    }

    private void inputString() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter string: ");
            input = br.readLine();
            br.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    private void inputIndexes() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter indexes for exchange: ");
            firstIndex = sc.nextInt();
            secondIndex = sc.nextInt();
            sc.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    private void exchange() {
        String newString = "";
        char ch1;
        char ch2;
        ch1= input.charAt(firstIndex);
        ch2= input.charAt(secondIndex);
        newString = input.substring(0,firstIndex) + ch2 + input.substring(firstIndex, secondIndex) + ch1 + input.substring(secondIndex);
        System.out.println(newString);
    }

}
