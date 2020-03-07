package homeworks.homework2_arrays.strategy;

import homeworks.control.exeption.IllegalDataException;
import homeworks.control.services.ServiceImpl;

public class MakeString extends ServiceImpl {

    @Override
    public String getResult(String userRequest) {
        String[] temp = userRequest.split("\\s+");
        int amount = 3;
        if (temp.length == amount && isEvenOdd(temp[2])){
            Integer[] body = chekArray(temp[0] + " " + temp[1]);
            Character[][] symbols = getArray(body[0],body[1]);
            String result ="";
            if (EVEN.equals(temp[2])){
                result = build(new EvenBuildStrategy(),symbols);
            } else if (ODD.equals(temp[2])){
                result = build(new OddBuildStrategy(),symbols);
            }
            return result;
        }else {
            throw new IllegalDataException(userRequest + "is not like \"some int some int even/odd\"");
        }
    }

    private Character[][] getArray(int a, int b){
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
    private String build(BuildStrategy buildStrategy, Character[][] chars) {
        return buildStrategy.build(chars);
    }
}
