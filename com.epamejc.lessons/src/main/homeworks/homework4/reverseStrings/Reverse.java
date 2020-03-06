package main.homeworks.homework4.reverseStrings;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Reverse {

    private String input;

    public void setInput(String input) {
        this.input = input;
    }

    public void run() {
        inputString();
        System.out.println(reverseString());
    }

    public void inputString() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter string: ");
            input = br.readLine();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    public String reverseString() {
        String world;
        String result = "";
        int first = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                world = input.substring(first,i);
                result += reverseWorld(world) + " ";
                first = i+1;
            }
            if (i == input.length() - 1) {
                world = input.substring(first);
                result += reverseWorld(world);
            }
        }
        return result;
    }

    public String reverseWorld(String world) {
        String result = "";
        for (int i = world.length() - 1; i >= 0; i--) {
            result += world.charAt(i);
        }
        return result;
    }

}
