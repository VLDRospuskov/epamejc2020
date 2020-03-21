package main.java.homework.recursion.recursion1;
import java.util.Scanner;

public class Fibonacci {

    public void run () {
        System.out.println("input the amount of numbers");
        Scanner in = new Scanner(System.in);

        int amount = in.nextInt();
        for(int N=0;N<amount;N++)System.out.print(F(N) + " ");
    }

        private static long F(int N){
            if(N==0)return 0;
            if(N==1)return 1;
            return F(N-1)+F(N-2);
        }

}
