package main.lessons.lesson4.recursion;

public class Main {

    public static void main(String[] args) {
        //cycle();
        //System.out.println(recursionString(4, "Level"));
        //System.out.println(factorial2(5));
        //System.out.println(factorial3(5));
        //System.out.println(number2powerRecursion(3, 3));
        System.out.println(bunnyEarsRecursion(4));
    }

    private static void cycle() {
        for(int i = 0; i < 10; i++) {
            System.out.println("hello");
        }
    }

    // 4 -> 3 -> 2 -> 1 Here Bye Bye Bye Bye
    private static String recursionString(int n, String str) {
        if (n == 1) {
            System.out.println("Here");
            return str;
        }
        return str + "\n" + recursionString( n - 1, str + n);
    }

    // 5! = 1 * 2 * 3 * 4 * 5 = 120
    private static int factorial(int n) {
        int result = 1;
        int i = 1;
        while (i <= n) {
            result *= i;
            i++;
        }
        return result;
    }

    // 5 -> 4 -> 3 -> 2 -> 1 = Here 1 * 2 * 3 * 4 * 5 = 120
    private static int factorial2(int n) {
        int result = 1;
        if (n == 1) {
            System.out.println("Here");
            return result;
        }
        return n * factorial2(n - 1);
    }

    private static int factorial3(int n) {
        return n == 1 ? 1 : n * factorial3(n - 1);
    }

    //1 - 1; 2 - 3; 3 - 6; 4 - 10;
    private static int number2powerRecursion(int base, int pow)
    {
        if (pow == 1)
        {
            return base;
        }
        return base * number2powerRecursion(base, pow - 1);
    }

    private static int bunnyEarsRecursion(int bunny)
    {
        if (bunny == 0) {
            return 0;
        }
        return 2 + bunnyEarsRecursion(bunny-1);
    }
}
