package homework.homework1;

import java.util.Scanner;

class Input {
    public static void inputTime(){
        System.out.print("Enter number: ");
        while (true) {
            Scanner sc = new Scanner(System.in);
            String inputValue = sc.next();
            if (inputValue != null && inputValue.length() != 0 && !inputValue.equals("exit")) {
                if (isNumeric(inputValue)) {
                    Double time = Double.parseDouble(inputValue);
                    if (time >= 0 && time <= 3.0) {
                        System.out.println(Colors.GREEN);
                    } else if (time >= 4.0 && time <= 5.0) {
                        System.out.println(Colors.YELLOW);
                    } else if (time >= 6.0 && time <= 8.0) {
                        System.out.println(Colors.RED);
                    } else {
                        System.out.println("Out of range('0-3', '4-5', '6-8')");
                    }
                } else {
                    System.out.println("Enter a number or exit");
                }
            } else if (inputValue.equals("exit")) {
                System.out.println("Ending program");
                break;
            } else {
                System.out.println("Enter a number or exit");
            }
        }
    }

    private static Boolean isNumeric (String str) {
        String regexDecimal = "^-?\\d*\\.\\d+$";
        String regexInteger = "^-?\\d+$";
        String regexDouble = regexDecimal + "|" + regexInteger;
        Boolean bool = str.matches(regexDouble);
        return bool;
    }
}
