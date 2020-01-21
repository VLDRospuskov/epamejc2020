package main.homework2.Strings;

import main.homework2.Prog.Programm;

import java.io.IOException;

public class RewerseWordsExt extends Programm {
    public static void main(String[] args) throws IOException {
        new RewerseWordsExt().go();
    }
    @Override
    public String startString() {
        return STARTSTRING;
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
        String result = ALERTDATA;
        if (Finput != null && Finput.length() > 0){
           result = changeStr(Finput);
        }
        return result;
    }

    private String changeStr(String string){
        String result = "";
        String str = string.replaceAll("[^\\p{L}]", " ");
        String[] temp = str.split("\\s+");
        int j = 0;
        for (int i = 0; i < string.length(); i++){
            if(j < temp.length && temp[j].length() + i <= string.length() && string.substring(i,i+temp[j].length()).equals(temp[j])){
                result += reverse(temp[j]);
                i += temp[j].length()-1;
                j++;
            } else {
                result += string.substring(i,i+1);
            }
        }
        return result;
    }
    private String reverse(String word){
        String result = "";
        for(int i = word.length()-1; i >= 0;i--){
            result += word.charAt(i);
        }
        return result;
    }

}

