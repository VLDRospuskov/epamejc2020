package homework5.RecursionNumberCounting;

class recursionNumberCounting {

    int numCounter(int num) {
        int col = 1;
        if (num / 10 == 0) {
            return 1;
        } else {
            col += numCounter(num / 10);
        }
        return col;
    }
}
