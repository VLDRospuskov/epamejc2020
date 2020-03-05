package homework3.StringReversStr;

import java.util.Scanner;

class StringReversStr {
    private String str;

    public void run() {
        getStr();
        reversStr();
    }

    private void getStr() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string: ");
        str = new String(in.nextLine().toString());
    }

    private void reversStr() {
        int firstWord = 0;
        int Space = 0;
        String strToReverse;
        while (true) {
            Space = str.indexOf(" ", Space);// find index of space
            if (Space == -1) {
                strToReverse = str.substring(firstWord, str.length());
                System.out.println(new StringBuffer(strToReverse).reverse());
                break;
            } else {
                strToReverse = str.substring(firstWord, Space);
                System.out.println(new StringBuffer(strToReverse).reverse());
                firstWord = Space;
                Space += 1;
            }
        }

    }
}
