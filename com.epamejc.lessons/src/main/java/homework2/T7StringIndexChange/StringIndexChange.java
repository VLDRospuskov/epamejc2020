package homework2.T7StringIndexChange;

import java.util.Scanner;

class StringIndexChange {

    private String str;
    private String fw;
    private String sw;

    StringIndexChange() {
        this.GetStr();
        this.ChangeChar();
    }

    private void GetStr() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string: ");
        this.str = in.nextLine().toString();
    }

    private void GetFirstWord() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter first word (0 to " + (str.length() - 1) + "): ");
        this.fw = in.nextLine().toString();
    }

    private void GetSecondWord() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter second word (" + (Integer.parseInt(fw) + 1) + " to " + (str.length() - 1) + "): ");
        this.sw = in.nextLine().toString();
    }

    private void ChangeChar() {
        this.GetFirstWord();
        if (!((Integer.parseInt(this.fw) > -1) && (Integer.parseInt(this.fw) < this.str.length()))) {
            System.out.println("Err!");
            return;
        }
        this.GetSecondWord();
        if (!((Integer.parseInt(this.sw) >= ((Integer.parseInt(this.fw) + 1)) && (Integer.parseInt(this.sw) < this.str.length())))) {
            System.out.println("Err!!");
            return;
        }
        System.out.println(this.str.substring(0, Integer.parseInt(this.fw))
                + this.str.charAt(Integer.parseInt(this.sw))
                + this.str.substring(Integer.parseInt(this.fw) + 1, Integer.parseInt(this.sw))
                + this.str.charAt(Integer.parseInt(this.fw))
                + this.str.substring(Integer.parseInt(this.sw) + 1));
    }
}
