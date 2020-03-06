package homework3.ArrayPyramid;

import java.util.Scanner;

class buildPyramid {
    private int height = 0;

    public void run() {
        getHeight();
        buildPyramidLogic buildPyramidLogic = new buildPyramidLogic();
        System.out.println(buildPyramidLogic.buildPyramid(height));
    }

    private void getHeight() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter height ");
        this.height = Integer.parseInt(in.nextLine()) + 1;
    }



}

