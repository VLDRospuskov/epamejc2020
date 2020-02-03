package main.homeworks.homework2.recursion;

import main.homeworks.homework2.prog.Programm;

import java.io.IOException;

public class CountNums extends Programm {
    public static void main(String[] args) throws IOException {
        new CountNums().go();
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
        Integer num = chekInt(Finput);
        String result = ALERTDATA;
        if (num != null){
            num = Math.abs(num);
            result = String.valueOf(countNum(num));
        }
        return result;
    }
    private int countNum (int num){
        if(num < 10){
            return 1;
        }else{
            return 1 + countNum(num/10);
        }
    }
}
