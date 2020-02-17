package main.homeworks.java.homework4.strings.task3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CharacterSwapper {


    private String inputString;


    public CharacterSwapper(String inputString) {
        this.inputString = inputString;
    }



    public String swap(int index1, int index2) {
        char[] chars = inputString.toCharArray();
        char temp = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = temp;
        return new String(chars);
    }


}
