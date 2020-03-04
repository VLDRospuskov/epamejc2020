package homework.homework2.recursion;

public class Pow {
    public static double getPow(double number, int pow) {

        if ( pow == 0 || (Double.compare(number, 1)==0) ) {
            return 1.0;
        }

        if ( Double.compare(number, 0)==0 ) {
            return 0.0;
        }

        double positivePow = getPow(number, number, 1, Math.abs(pow));

        if (pow < 0) {
            return 1 / positivePow;
        }

        return positivePow;
    }

    private static double getPow(double accamulatedProduct, double second, int currentPow, int requiredPow) {

        if (currentPow == requiredPow)
            return accamulatedProduct;

        if (currentPow > requiredPow)
            throw new IllegalArgumentException();

        return getPow(accamulatedProduct * second, second, currentPow + 1, requiredPow);
    }
}
