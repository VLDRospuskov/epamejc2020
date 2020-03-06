package homework3.StringReversStr;

import java.util.Scanner;

class stringReversStrLogic {
    private String str;

    public void run() {
        getStr();
        stringReversStr stringReversStr = new stringReversStr();
        System.out.println(stringReversStr.reversStr(str));

    }

    private void getStr() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string: ");
        str = new String(in.nextLine().toString());
    }


}
