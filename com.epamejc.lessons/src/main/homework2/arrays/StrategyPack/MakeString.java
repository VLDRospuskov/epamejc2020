package main.homework2.arrays.StrategyPack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class MakeString {
    public static void main(String[] args) {
        MakeString makeString = new MakeString();
        makeString.go();
    }
    public void go(){
        BuildStrategy evenStrategy = new EvenBuildStrategy();

        BuildStrategy oddStrategy = new OddBuildStrategy();

        String start = "Введите два индекса через пробел";

        String alertData = "Некорректный ввод";

        String chooseStrategy = "Какая стратегия ? А или B?";

        String exit = "exit";

        boolean isStop = false;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int length1 = 0;

        int length2 = 0;

        while(!isStop){
            try {
                System.out.println(start);

                String input = reader.readLine();

                if (input.equals(exit)){
                    isStop = true;
                }else{
                    if (input.length()>0){
                        try {
                          String[] temp = input.split("\\s+");
                          if (temp.length == 2){

                              length1 = Integer.parseInt(temp[0]);

                              length2 = Integer.parseInt(temp[1]);

                              char[][] result = makeArray(length1,length2);

                              System.out.println(chooseStrategy);

                              String strategy = reader.readLine();

                              if (strategy.equals("A")){
                                  System.out.println(build(evenStrategy,result));

                              } else if (strategy.equals("B")){
                                  System.out.println(build(oddStrategy,result));
                              }
                          } else {
                              System.out.println(alertData);
                          }
                        } catch (Exception ex){
                            System.out.println(alertData);
                        }
                    }
                }
            } catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }
    private char[][] makeArray(int a, int b){
        char[][] result = new char[a][b];
        if (0 < a && 0 < b){
            for(int i = 0; i < a; i++){
                for (int j = 0; j < b; j++){
                    Random r = new Random();
                    result[i][j] =  (char)(r.nextInt(26) + 'a');
                    System.out.print(result[i][j]);
                }
                System.out.println();
            }
        }
        return result;
    }
    public String build(BuildStrategy buildStrategy, char[][] chars) {
       return buildStrategy.build(chars);
    }
}
