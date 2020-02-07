package homeworks.homework2.recursion;

import homeworks.control.exeption.IllegalDataException;
import homeworks.control.services.ServiceImpl;

import java.math.BigDecimal;

public class Exponentiation extends ServiceImpl {

    @Override
    public String getResult(String userRequest) {
        String[] temp = userRequest.split("\\s+");
        if (temp.length == 2){
            Integer num = chekInt(temp[0]);
            Integer pow = chekInt(temp[1]);
            return String.valueOf(exponent(num,pow));
        } else {
            throw new IllegalDataException(userRequest + " dont contains two ints");
        }
    }

    private double exponent(int num,int pow){

        if (pow < 0){
            return 1/exponent(num,Math.abs(pow));
        }
        if (pow == 0){
            return 1;
        }
        if (num == 0){
            return num;
        }
        if(pow == 1){
            return num;
        } else{
            return num * exponent(num,pow-1);
        }
    }
}
