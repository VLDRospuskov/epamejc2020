package homeworks.homework2.recursion;

import homeworks.control.services.ServiceImpl;

public class FibonacciNumbers extends ServiceImpl {
    @Override
    public String getResult(String userRequest) {
        Integer input = chekInt(userRequest);
        return String.valueOf(fibonacci(input));
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
