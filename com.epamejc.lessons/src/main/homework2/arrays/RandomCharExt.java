package main.homework2.arrays;

import main.homework2.Prog.Programm;

import java.io.IOException;

public class RandomCharExt extends Programm {
    public static void main(String[] args) throws IOException {
        new RandomCharExt().go();
    }
    @Override
    public String startString() {
        return STARTNUMBERS;
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

        Integer[] input = chekArray(Finput);

        String result = ALERTDATA;

        if (input != null){

            return makeArray(input[0],input[1]);
        }

        return result;
    }
    private String makeArray(int ind1, int ind2){
        char[][] result = new char[ind1][ind2];

        for (int i = 0 ; i < ind1; i++){

            for (int j = 0; j < ind2; j++){

                result[i][j] = makeRandomChar();

            }

        }

        return printArray(result);
    }
    private String printArray(char[][] result){
        String res = "";

        for (int i = 0 ; i < result.length; i++){

            for (int j = 0; j < result[i].length; j++){
                res += result[i][j] + " ";
            }

                res += "\n";
        }
        return res;
    }
}
