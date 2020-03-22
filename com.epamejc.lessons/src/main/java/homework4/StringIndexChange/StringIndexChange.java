package homework4.StringIndexChange;

import java.util.Scanner;

class StringIndexChange {

    private String str;
    private String fw;
    private String sw;

    public void run() {
        GetStr();
        ChangeChar();
    }

    private void GetStr() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string: ");
        str = in.nextLine();
    }

    private void GetFirstWord() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter first word (0 to " + (str.length() - 1) + "): ");
        fw = in.nextLine();
    }

    private void GetSecondWord() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter second word (" + (Integer.parseInt(fw) + 1) + " to " + (str.length() - 1) + "): ");
        sw = in.nextLine();
    }

    private void ChangeChar() {
        GetFirstWord();
        if (!((Integer.parseInt(fw) > -1) && (Integer.parseInt(fw) < str.length()))) {
            System.out.println("Err");
            return;
        }
        GetSecondWord();
        if (!((Integer.parseInt(sw) >= ((Integer.parseInt(fw) + 1)) && (Integer.parseInt(sw) < str.length())))) {
            System.out.println("Err");
            return;
        }
        System.out.println(str.substring(0, Integer.parseInt(fw))
                + str.charAt(Integer.parseInt(sw))
                + str.substring(Integer.parseInt(fw) + 1, Integer.parseInt(sw))
                + str.charAt(Integer.parseInt(fw))
                + str.substring(Integer.parseInt(sw) + 1));
    }
}
