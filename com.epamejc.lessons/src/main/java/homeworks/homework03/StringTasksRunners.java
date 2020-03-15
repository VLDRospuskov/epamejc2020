package homeworks.homework03;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StringTasksRunners {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringMethods stringMethods = new StringMethods();

    @SneakyThrows
    private String readString() {
        return reader.readLine();
    }

    @SneakyThrows
    public String runGeneratingStringFromCharactersAtIndexes() {
        System.out.print("Enter string: ");
        String value = readString();
        int index;
        String input;
        String result = "";
        System.out.println("Enter index from 0 to " + (value.length() - 1));
        while ((input = readString()).equals("exit")) {
            index = Integer.parseInt(input);
            result += stringMethods.getCharFromStringAtIndex(value, index);
        }

        System.out.println("Result is: " + result);
        return result;
    }

    @SneakyThrows
    public String runSwappingLetters() {
        System.out.print("Enter String: ");
        String value = readString();
        System.out.println("Enter first index");
        int a = Integer.parseInt(reader.readLine());
        System.out.println("Enter second index");
        int b = Integer.parseInt(reader.readLine());

        String result = stringMethods.swapLetters(value, a, b);
        System.out.println(result);
        return result;
    }

}
