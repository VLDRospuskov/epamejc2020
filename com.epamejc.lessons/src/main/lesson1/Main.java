package main.lesson1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true){
            System.out.print("Input a number: ");
            int num = in.nextInt();
            if(num>0 && num<=3){
                System.out.println("green");
            }else if (num>3 && num<=5){
                System.out.println("yellow");
            }else if(num>5 && num<=10){
                System.out.println("red");
            }else {
                System.out.println(" smth else");
            }
        }
    }

}
