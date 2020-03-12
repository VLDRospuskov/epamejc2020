package homework.homework9.util;

import org.apache.commons.math3.util.Precision;

import java.util.Random;

public class RandomUtil {
    private static final Random RANDOM = new Random();

    public static double nextDoubleBetween(double min, double max) {
        return min + (max - min) * Precision.round(RANDOM.nextDouble(), 2);
    }
}
