package homeworks.HW_5_recursion.raiseToThePower;

import homeworks.utility.helper.CancellationException;
import homeworks.utility.helper.Helper;

class RaiseToThePower {

    public void run() {
        try {
            System.out.println(Helper.GREETING);

            while (true) {
                int input1 = Helper.getInt("Input number: ");
                int number = Math.max(0, input1);
                int input2 = Helper.getInt("The power of the number: ");
                int row = Math.max(0, input2);

                PrintPowerOfNumber(number, row);
            }
        } catch (CancellationException ignored) {}
    }

    private void PrintPowerOfNumber(int number, int row) {
        if (number != 0 || row != 0) {
            int result = getPowerOfNumber(number, row);
            System.out.println("The number " + number + " to the power of " + row +
                    " is equal to " + result);
        } else {
            System.out.println("Invalid operation (0 to the power of 0). Try it again.");
        }

        System.out.println("------------------------------------------");
    }

    public static int getPowerOfNumber(int n, int p) {
        if (p == 0) {
            return 1;
        } else if (p == 1) {
            return n;
        } else {
            return n * getPowerOfNumber(n, p - 1);
        }
    }

}
