package homework4.StringRandomNewStr;

import java.util.Scanner;

class stringRandomNewStrLogic {
    private String str;
    private String typeOfStrategy;

    public void run() {
        getStrAndStrategy();
        stringRandomNewStr stringRandomNewStr = new stringRandomNewStr();
        stringRandomNewStr.applyStrategy(str, typeOfStrategy);
    }

    private void getStrAndStrategy() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string: ");
        str = in.nextLine();
        System.out.print("Enter strategy(A or B) ");
        typeOfStrategy = (in.nextLine());
    }
}
