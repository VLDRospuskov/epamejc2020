package main.homework2.Strings;

import main.homework2.Prog.Programm;

import java.io.IOException;

public class MakeWord extends Programm {
    String word;
    String result = "";
    public static void main(String[] args) throws IOException {
        new MakeWord().go();
    }

    @Override
    public String startString() {
        return STARTSTRING;
    }

    @Override
    public String secondInputString() {
        return STARTNUMBER;
    }

    @Override
    public int inputtimes() {
        return 2;
    }

    @Override
    public String makeResult(String Finput, String Sinput) {

        Integer index = chekInt(Sinput);
        if (index == null){
            return result;
        }
        if (word == null || !word.equals(Finput)){
            word = Finput;
            result = "";
        }
        if (0 < Finput.length() && index < Finput.length()){
            result = result + makeWord(Finput,index);
        } else {
            result = ALERTNUM;
        }
        return result;
    }
    public String makeWord(String string, int exit){
        String res = string.substring(exit,exit+1);
        return res;
    }
}
