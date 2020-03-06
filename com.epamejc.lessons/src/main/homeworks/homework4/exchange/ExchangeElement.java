package main.homeworks.homework4.exchange;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ExchangeElement {

    private String input;
    private int firstIndex;
    private int secondIndex;

    public void setInput(String input) {
        this.input = input;
    }

    public void setFirstIndex(int firstIndex) {
        this.firstIndex = firstIndex;
    }

    public void setSecondIndex(int secondIndex) {
        this.secondIndex = secondIndex;
    }

    public String getInput() {
        return input;
    }

    public int getFirstIndex() {
        return firstIndex;
    }

    public int getSecondIndex() {
        return secondIndex;
    }

    public void run() {
        inputString();
        inputIndexes();
        System.out.println(exchange());
    }

    public void inputString() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter string: ");
            input = br.readLine();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    public void inputIndexes() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter indexes for exchange: ");
            firstIndex = sc.nextInt();
            secondIndex = sc.nextInt();
            sc.close();
        } catch (Exception e) {
            System.out.println("Enter numbers.");
            inputIndexes();
        }
    }

    public String exchange() {
        char ch1;
        char ch2;
        ch1= input.charAt(firstIndex);
        ch2= input.charAt(secondIndex);
        String front = "";
        if (firstIndex != 0 ) {
            front = input.substring(0,firstIndex);
        }
        String back = "";
        if (secondIndex != input.length()-1 ) {
            back = input.substring(secondIndex + 1);
        }
        String newString = front  + ch2 + input.substring(firstIndex + 1, secondIndex) + ch1 + back;
        return newString;
    }

}
