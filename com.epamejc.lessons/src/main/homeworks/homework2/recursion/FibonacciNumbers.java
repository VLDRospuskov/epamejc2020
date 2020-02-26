package homeworks.homework2.recursion;

import homeworks.control.exeption.IllegalDataException;
import homeworks.control.services.ServiceImpl;

public class FibonacciNumbers extends ServiceImpl {
    @Override
    public String getResult(String userRequest) throws IllegalDataException{
        Integer input = chekInt(userRequest);
        if (input >= 0 ){
            return String.valueOf(fibonacci(input));
        } else {
            throw new IllegalDataException(userRequest + " input can't be negative");
        }

    }

    private int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
