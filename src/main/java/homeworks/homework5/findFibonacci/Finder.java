package homeworks.homework5.findFibonacci;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Finder {

    private int count;
    private List<Integer> array = new ArrayList<>();

    void run () {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {

                System.out.print("Enter array length or 'exit': ");
                String userNumber = reader.readLine();

                if (isPositiveAndNotZero(userNumber)) {
                    findAndShowResult(userNumber);
                } else if (userNumber.equalsIgnoreCase("exit")) {
                    System.out.println("Finder stopped!");
                    break;
                } else {
                    System.out.println("Length must be a positive single number and less then 5000");
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void findAndShowResult(String userNumber) {
        count = 2;
        int size = Integer.parseInt(userNumber);
        int[] randomArray = generateRandomArray(size);
        List<Integer> allFibonacci = findAllFibonacci(randomArray);
        if (!array.isEmpty()) {
            System.out.println(allFibonacci.toString());
            array.clear();
        } else {
            System.out.println("No Fibonacci here");
        }
    }


    private int[] generateRandomArray(int size) {
        int[] randomArray = new int[size];
        Random randomInteger = new Random();
        for (int i=0; i<size; i++) {
            randomArray[i] = randomInteger.nextInt(100);
        }
        return randomArray;
    }


    private List<Integer> findAllFibonacci (int[] randomArray) {
        if (count < randomArray.length && (randomArray[count] == randomArray[count-2] + randomArray[count-1])) {
            array.add(randomArray[count]);
            count++;
            findAllFibonacci(randomArray);
            return array;
        } else if (count < randomArray.length) {
            count++;
            findAllFibonacci(randomArray);
            return array;
        } else {
            return array;
        }
    }


    private boolean isPositiveAndNotZero (String str) {
        String regexInteger = "^-?\\d+$";
        return str.matches(regexInteger) && Integer.parseInt(str)>0 && Integer.parseInt(str)<=5000;
    }
}
