package homework2.T6StringGenStrByIndex;


import java.util.Scanner;

class StringGenStrByIndex {
    private String str;
    private int min;

    StringGenStrByIndex() {
        this.getStr();
        this.GenStr();
    }

    private void getStr() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string: ");
        this.str = (in.nextLine());
    }

    private void getMin() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter sec(1 to " + str.length() + "; -1 to exit): ");
        this.min = Integer.parseInt(in.nextLine());
    }

    private void GenStr() {
        StringBuilder finalStr = new StringBuilder();
        while (true) {
            this.getMin();
            if ((this.min) == (-1)) {
                break;
            }
            if ((min >= 1 && (min <= str.length()))) {
                finalStr.append(this.str.charAt(this.min - 1));
                System.out.println(finalStr);
            } else {
                System.out.println("Err");
            }
        }
    }
}
