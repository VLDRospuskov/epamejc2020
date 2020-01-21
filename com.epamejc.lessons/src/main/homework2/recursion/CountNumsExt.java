package main.homework2.recursion;

import main.homework2.Prog.Programm;

import java.io.IOException;

public class CountNumsExt extends Programm {
    public static void main(String[] args) throws IOException {
        new CountNumsExt().go();
    }

    @Override
    public String startString() {
        return STARTNUMBER;
    }

    @Override
    public String seondInputString() {
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
