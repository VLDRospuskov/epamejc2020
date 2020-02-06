package homeworks.homework2.recursion;

import homeworks.control.services.ServiseImpl;

public class CountNums extends ServiseImpl {
    @Override
    public String getResult(String userRequest) {
        Integer num = chekInt(userRequest);
        num = Math.abs(num);
        return String.valueOf(countNum(num));
    }

    private int countNum (int num){
        if(num < 10){
            return 1;
        }else{
            return 1 + countNum(num/10);
        }
    }
}
