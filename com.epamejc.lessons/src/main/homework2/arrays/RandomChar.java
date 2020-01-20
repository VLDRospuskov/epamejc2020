package main.homework2.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class RandomChar {
    public static void main(String[] args) {
        RandomChar randomChar = new RandomChar();
        randomChar.go();
    }
    public void go(){
        String start1 = "Введите вертикальную длину";

        String start2 = "Введите вертикальную длину";

        String indexAlert = "Некорректные данные";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean isStop = false;

        while (!isStop){
            try{
                System.out.println(start1);
                String index1 = reader.readLine();

                System.out.println(start2);
                String index2 = reader.readLine();

                isStop = isStoped(index2);
                isStop = isStoped(index1);

                if (isStop){
                    break;
                }

                try {
                    int ind1 = Integer.parseInt(index1);
                    int ind2 = Integer.parseInt(index2);

                    if(0 < ind1 && 0 < ind2) {
                        Character[][] result = makeArray(ind1,ind2);
                        printArray(result);

                    } else{
                        System.out.println(indexAlert);
                    }

                 }catch (Exception ex){
                    System.out.println(indexAlert);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private boolean isStoped(String str){
        return str.equals("exit");
    }
    private Character[][] makeArray(int ind1, int ind2){
        Character[][] result = new Character[ind1][ind2];

        for (int i = 0 ; i < ind1; i++){

            for (int j = 0; j < ind2; j++){

                Random r = new Random();
                result[i][j] =  (char)(r.nextInt(26) + 'a');
            }

        }
        return result;
    }
    private void printArray(Character[][] result){

        for (int i = 0 ; i < result.length; i++){

            for (int j = 0; j < result[i].length; j++){
                System.out.print(result[i][j] + " ");
            }

            System.out.println();
        }
    }
}
