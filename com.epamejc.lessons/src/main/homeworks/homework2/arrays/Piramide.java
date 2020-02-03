package main.homeworks.homework2.arrays;


import main.homeworks.homework2.prog.Programm;

import java.io.IOException;


public class Piramide extends Programm {
    public static void main(String[] args) throws IOException {
        new Piramide().go();
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
        Integer pirLength = chekInt(Finput);
        String result = ALERTDATA;
        if (pirLength != null && pirLength <= 0){
            result = ALERTNUM;
        } else if (pirLength != null){
            result = makePiramide(pirLength);
        }
        return result;
    }
    public String makePiramide(int piLength){

        char[][] strings = new char[piLength][];

        String result = "";

        char ab = makeRandomChar();

        for (int i = 0; i < piLength; i++){

            char[] simb = new char[piLength-i];

            for(int j = 0; j < piLength-i; j++){
                simb[j] = ab;
            }

            strings[i] = simb;
        }

        for (int i = 0; i < piLength; i++){

            for(int j = 0; j < piLength-i; j++){
                result += strings[i][j];
            }

            result += "\n";
        }
        return  result;
    }
}
