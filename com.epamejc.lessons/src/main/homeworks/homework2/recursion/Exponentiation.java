package main.homeworks.homework2.recursion;

import main.homeworks.homework2.prog.Programm;

import java.io.IOException;

public class Exponentiation extends Programm {
    public static void main(String[] args) throws IOException {
        new Exponentiation().go();
    }
    @Override
    public String startString() {
        return STARTNUMBER;
    }

    @Override
    public String secondInputString() {
        return STARTPOW;
    }

    @Override
    public int inputtimes() {
        return 2;
    }

    @Override
    public String makeResult(String Finput, String Sinput) {
        Double num = chekDouble(Finput);

        Integer pow = chekInt(Sinput);

        boolean chek = num != null && pow != null;

        if (!chek){
            return ALERTDATA;
        } else if(pow <= 0){
            return ALERTPOW;
        }else {
            return String.valueOf(exponent(num,pow));
        }
    }
    private double exponent(double num,int pow){
        if(pow == 1){

            return num;

        } else{
            double result = 0;

            result = num * exponent(num,pow-1);

            return result;
        }
    }
}
