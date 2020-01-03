package homework.homework1;

import java.util.Scanner;

class TrafficLight {

    public void showColors(){
        System.out.print("Enter time: ");
        while (true) {
            Scanner sc = new Scanner(System.in);
            String inputValue = sc.next();
            if (inputValue != null && inputValue.length() != 0 && isNumeric(inputValue)) {
                double time = Double.parseDouble(inputValue);
                getColor(time);
                System.out.print("Enter again or type 'exit': ");
            } else if (inputValue.equals("exit")) {
                System.out.println("Ending program!");
                break;
            } else {
                System.out.println("Time should be a digit");
            }
        }
    }

    private void getColor (double time) {
        if (time >= 0 && time < 4.0) {
            System.out.println(Colors.GREEN);
        } else if (time >= 4.0 && time < 6.0) {
            System.out.println(Colors.YELLOW);
        } else if (time >= 6.0 && time <= 10.0) {
            System.out.println(Colors.RED);
        } else {
            System.out.println("Out of range('0-4', '4-6', '6-10')");
        }
    }

    private Boolean isNumeric (String str) {
        String regexDecimal = "^-?\\d*\\.\\d+$";
        String regexInteger = "^-?\\d+$";
        String regexDouble = regexDecimal + "|" + regexInteger;
        return str.matches(regexDouble);
    }
}
