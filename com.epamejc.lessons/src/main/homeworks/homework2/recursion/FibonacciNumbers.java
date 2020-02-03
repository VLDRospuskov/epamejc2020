package main.homeworks.homework2.recursion;

import main.homeworks.homework2.prog.Programm;

import java.io.IOException;

public class FibonacciNumbers extends Programm {
    public static void main(String[] args) throws IOException {
        new FibonacciNumbers().go();
    }
    @Override
    public String startString() {
        return STARTNUMBER;
    }

    @Override
    public String secondInputString() {
        return null;
    }

    @Override
    public int inputtimes() {
        return 1;
    }

    @Override
    public String makeResult(String Finput, String Sinput) {
        Integer input = chekInt(Finput);
        if (input!=null){
            return String.valueOf(fibonacci(input));
        }else {
            return ALERTDATA;
        }
    }
    private int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
