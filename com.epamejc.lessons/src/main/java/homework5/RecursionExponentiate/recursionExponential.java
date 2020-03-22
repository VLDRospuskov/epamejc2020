package homework5.RecursionExponentiate;

class recursionExponential {

    int step(int num, int pow) {
        if (pow == 0) {
            return 1;
        }
        if (pow == 1) {
            return num;
        }
        return num * step(num, pow - 1);
    }
}
