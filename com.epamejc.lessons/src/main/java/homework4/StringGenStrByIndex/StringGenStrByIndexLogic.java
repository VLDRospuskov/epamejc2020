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
        min = readCom("Enter sec(1 to " + str.length() + "; -1 to exit): ");
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

    private int readCom(String text) {
        boolean t;
        int command = 0;
        do {
            try {
                System.out.print(text);
                Scanner in = new Scanner(System.in);
                command = in.nextInt();
                t = false;
            } catch (Exception e) {
                t = true;
                System.out.println("Input Error.");
            }
        } while (t);
        return command;
    }
}
