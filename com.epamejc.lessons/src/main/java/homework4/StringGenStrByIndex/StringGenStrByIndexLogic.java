package homework4.StringGenStrByIndex;


import java.util.Scanner;

class StringGenStrByIndexLogic {
    private String str;
    private int min;

    public void run() {
        getStr();
        GenStr();
    }

    private void getStr() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string: ");
        str = (in.nextLine());
    }

    private void getMin() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter sec(1 to " + str.length() + "; -1 to exit): ");
        min = Integer.parseInt(in.nextLine());
    }

    private void GenStr() {
        StringBuilder finalStr = new StringBuilder();
        while (true) {
            getMin();
            if ((min) == (-1)) {
                break;
            }
            if ((min >= 1 && (min <= str.length()))) {
                finalStr.append(str.charAt(min - 1));
                System.out.println(finalStr);
            } else {
                System.out.println("Err");
            }
        }
    }
}
