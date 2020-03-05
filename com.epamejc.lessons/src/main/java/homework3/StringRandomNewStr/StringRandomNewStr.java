package homework3.StringRandomNewStr;

import java.util.Scanner;

class StringRandomNewStr {
    private String str;
    private String typeOfStrategy;

    public void run() {
        getStrAndStrategy();
        applyStrategy();
    }

    private void getStrAndStrategy() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string: ");
        str = in.nextLine();
        System.out.print("Enter strategy(A or B) ");
        typeOfStrategy = (in.nextLine());

    }

    private void applyStrategy() {
        int i = 0;
        if ((typeOfStrategy.equals("B")) || (typeOfStrategy.equals("b"))) {
            i = 1;
        }
        while (i < str.length()) {
            System.out.print(str.charAt(i));
            i += 2;
        }
    }
}
