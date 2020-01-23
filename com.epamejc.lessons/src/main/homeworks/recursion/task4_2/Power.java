package main.homeworks.recursion.task4_2;

public class Power {

    public int calc(int n, int p){
        if (p == 0){
            return 1;
        }
        return n*calc(n,p-1);
    }
}
