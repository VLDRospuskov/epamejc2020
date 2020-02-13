package homeworks.java.hw3.arrays_3;

import static homeworks.java.hw3.utils.Utilities.*;

public class PyramidGenerator {

    public void run() {
        int number = scanNumber();
        PyramidBuilder pb = new PyramidBuilder();
        char[][] arr = pb.buildPyramid(number);
        printArray(arr);
    }

}
