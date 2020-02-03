package main.homeworks.homework2.arrays.StrategyPack;

public class EvenBuildStrategy implements BuildStrategy {
    public String build(Character[][] chars ){
        String result ="";
        if (chars.length>0){
            for (int i = 0; i < chars.length; i++){
                for (int j = 0; j < chars[i].length; j++){
                    if(j%2 == 0){
                        result += chars[i][j];
                    }
                }
            }
        }
        return result;
    }
}
