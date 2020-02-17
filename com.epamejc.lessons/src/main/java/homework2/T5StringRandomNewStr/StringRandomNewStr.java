package homework2.T5StringRandomNewStr;

import java.util.Scanner;

class StringRandomNewStr {
    private String str;
    private String typeOfStrategy;

    StringRandomNewStr() {
        this.getStrAndStrategy();
        this.applyStrategy();
    }

    private void getStrAndStrategy() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string: ");
        this.str = in.nextLine().toString();
        System.out.print("Enter strategy(A or B) ");
        this.typeOfStrategy = (in.nextLine());

    }

    private void applyStrategy() {
        int i = 0;
        if ((this.typeOfStrategy.equals("B")) || (this.typeOfStrategy.equals("b"))) {
            i = 1;
        }
        while (i < this.str.length()) {
            System.out.print(this.str.charAt(i));
            i += 2;
        }
    }
}
