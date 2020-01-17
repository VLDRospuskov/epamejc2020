package main.Homeworks.HW3.Task3Strings;

import java.util.Arrays;
import java.util.Scanner;

public class T33Swap {
    public void start() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String positions = scanner.nextLine();
        if (positions.contains(",")) {
            String[] posArr = positions.split(",");
            if (posArr.length > 2) {
                System.out.println("please use only one , (comma)");
                return;
            }
            if (isInteger(posArr[0].trim()) && isInteger(posArr[1].trim())) {
                int left = Integer.parseInt(posArr[0].trim());
                int right = Integer.parseInt(posArr[1].trim());
                if (left > input.length() || left < 0 || right > input.length() || right < 0 || left >= right) {
                    System.out.println("use correct digits");
                } else {
                    String out = "";
                    char leftC = input.charAt(left);
                    char rightC = input.charAt(right);
                    for (int i = 0; i < input.length(); i++) {
                        if (i == left) {
                            out = out + rightC;
                        } else if (i == right) {
                            out = out + leftC;
                        } else {
                            out = out + input.charAt(i);
                        }
                    }
                    System.out.println(out);
                }
            } else {
                System.out.println("must be two digits");
            }
        } else {
            System.out.println("please use , (comma) as delimiter");
            return;
        }
    }

    private boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
