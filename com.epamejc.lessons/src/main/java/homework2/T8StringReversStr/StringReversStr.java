package homework2.T8StringReversStr;

import java.util.Scanner;

class StringReversStr {
    private String str;

    StringReversStr() {
        this.getStr();
        this.reversStr();
    }

    private void getStr() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string: ");
        this.str = new String(in.nextLine().toString());
    }

    private void reversStr() {
        int firstWord = 0;
        int Space = 0;
        String strToReverse;
        while (true) {
            Space = this.str.indexOf(" ", Space);// find index of space
            if (Space == -1) {
                strToReverse = this.str.substring(firstWord, str.length());
                System.out.println(new StringBuffer(strToReverse).reverse());
                break;
            } else {
                strToReverse = this.str.substring(firstWord, Space);
                System.out.println(new StringBuffer(strToReverse).reverse());
                firstWord = Space;
                Space += 1;
            }
        }

    }
}
