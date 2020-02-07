package homeworks.homework2.recursion;

import homeworks.control.exeption.IllegalDataException;
import homeworks.control.services.ServiceImpl;

public class Exponentiation extends ServiceImpl {

    @Override
    public String getResult(String userRequest) {
        String[] temp = userRequest.split("\\s+");
        if (temp.length == 2){
            Double num = chekDouble(temp[0]);
            Integer pow = chekInt(temp[1]);
            return String.valueOf(exponent(num,pow));
        } else {
            throw new IllegalDataException(userRequest + "is not \" some number some integer\"");
        }
    }

    private double exponent(double num,int pow){
        if(pow == 1){
            return num;
        } else{
            double result = 0;
            result = num * exponent(num,pow-1);
            return result;
        }
    }
}
