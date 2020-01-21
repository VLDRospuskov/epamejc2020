package main.homework2.Strings;

import main.homework2.Prog.Programm;

import java.io.IOException;

public class SwitchCharExt extends Programm {
    public static void main(String[] args) throws IOException {
        new SwitchCharExt().go();
    }
    @Override
    public String startString() {
        return STARTSTRING;
    }

    @Override
    public String seondInputString() {
        return STARTNUMBERS;
    }

    @Override
    public int inputtimes() {
        return 2;
    }

    @Override
    public String makeResult(String Finput, String Sinput) {
        Integer[] temp = chekArray(Sinput);
        int min = 0;
        int max = Finput.length();
        String result = ALERTDATA;
        if (max > 0 && temp != null && min <= temp[0] && min <= temp[1] && temp[0] < max && temp[1] < max){
            result = makeString(Finput,temp[0],temp[1]);
        }
        return result;
    }
    public String makeString(String word, int ind1, int ind2){
        String first = word.substring(ind1,ind1+1);
        String second = word.substring(ind2,ind2+1);
        String result = "";
        for (int i = 0; i < word.length(); i++){
            if(i == ind1){
                result += second;
            } else if(i == ind2){
                result += first;
            } else {
                result += word.substring(i,i+1);
            }
        }
        return result;
    }
}
