package main.Homeworks.HW3.Task3Strings;

import java.util.Scanner;

public class T32Index {
    public void start() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String output = "";
        while (scanner.hasNext()) {
            int index = scanner.nextInt();
            for (int i = 0; i < input.length(); i++) {
                if (i == index) {
                    output = output + input.charAt(i);
                }
            }
            System.out.println(output);
        }
    }
}
