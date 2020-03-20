package homeworks.homework02;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter rows:");
        int rows = Integer.parseInt(reader.readLine());
        System.out.println("Enter columns:");
        int columns = Integer.parseInt(reader.readLine());

        ArrayMethods arrayMethods = new ArrayMethods();
        char[][] values = arrayMethods.createRandomLetterCharArray(rows, columns);
        arrayMethods.printCharArray(values);

        System.out.println("Enter strategy: A or B");
        String strategy = reader.readLine();
        System.out.println(arrayMethods.getStringFromCharArrayByStrategy(values, strategy));

        System.out.println("Enter int value:");
        int size = Integer.parseInt(reader.readLine());
        arrayMethods.printCharArray(arrayMethods.generatePyramid(size));
    }
}
