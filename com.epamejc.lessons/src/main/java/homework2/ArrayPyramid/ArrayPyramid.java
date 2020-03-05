package homework2.ArrayPyramid;

import java.util.Scanner;

class ArrayPyramid {
    private int height = 0;

    ArrayPyramid() {
        this.getHeight();
        this.buildPyramid();
    }

    private void getHeight() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter height ");
        this.height = Integer.parseInt(in.nextLine()) + 1;
    }

    private void buildPyramid() {
        if (this.height > 0) {
            String str = "X";
            StringBuilder strRepeat = new StringBuilder(str.repeat(this.height));
            for (int i = 0; i < this.height; i++) {
                strRepeat.setLength(strRepeat.length() - 1);
                System.out.println(strRepeat.toString());
            }
        }
    }


}

