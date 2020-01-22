package main.homework2.arrays.StrategyPack;

import main.homework2.Prog.Programm;

import java.io.IOException;

public class MakeString extends Programm {
    public static void main(String[] args) throws IOException {
        new MakeString().go();
    }
    @Override
    public String startString() {
        return STARTNUMBERS;
    }

    @Override
    public String secondInputString() {
        return STARTEVODD;
    }

    @Override
    public int inputtimes() {
        return 2;
    }

    @Override
    public String makeResult(String Finput, String Sinput) {
        Integer[] length = chekArray(Finput);
        String result = ALERTDATA;
        int first  = 0;
        int second = 0;
        if (length != null){
            first = length[0];
            second = length[1];
        }
        Character [][] simbols = null;
        if (0 < first && 0 < second){
            simbols  = makeArray(first,second);
        }
        if (EVEN.equals(Sinput)){
            result = build(new EvenBuildStrategy(),simbols);
        } else if(ODD.equals(Sinput)){
            result = build(new OddBuildStrategy(),simbols);
        }
        return result;
    }
    private Character[][] makeArray(int a, int b){
        Character[][] result = new Character[a][b];
        if (0 < a && 0 < b){
            for(int i = 0; i < a; i++){
                for (int j = 0; j < b; j++){
                    result[i][j] = makeRandomChar();
                    System.out.print(result[i][j]);
                }
                System.out.println();
            }
        }
        return result;
    }
    public String build(BuildStrategy buildStrategy, Character[][] chars) {
        return buildStrategy.build(chars);
    }
}
