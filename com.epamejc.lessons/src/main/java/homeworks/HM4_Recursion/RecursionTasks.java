/**
 4. Recursion
 4.1. Поиск числа Фиббоначи
 4.2. Написать программу которая умеет вовзодить в степени:
 input number: 4
 input pow: 3
 output: 64
 4.3.  Посчитать количество знаков в числе
 */

package homeworks.HM4_Recursion;

import lombok.Setter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Setter
public class RecursionTasks {

    private int value;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // TODO везде появились ридеры. Это норма?

    private void readInt() {
        System.out.print("Enter int: ");

        try {
            String stringValue = reader.readLine();
            value = Integer.parseInt(stringValue);
        } catch (NumberFormatException e) {
            System.out.println("Not a number!");
            readInt(); // TODO is it legal?
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 4.1
     */
    public int fibonacci(int n) {
        if (n <= 2) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    /**
     * 4.2
     */
    public int power(int a, int b){
        if (b == 1) return a;
        return a * power(a,b-1);
    }

    /**
     * 4.3
     */
    public int numberOfDigits(int n) {
        if (n/10 < 1) return 1;
        return numberOfDigits(n/10) + 1;
    }
}

