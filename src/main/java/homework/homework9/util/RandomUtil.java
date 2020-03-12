package homework.homework9.util;

import org.apache.commons.math3.util.Precision;

import java.util.List;
import java.util.Random;

public class RandomUtil {
    private static final Random RANDOM = new Random();

    public static double nextDoubleBetween(double min, double max) {
        return min + (max - min) * Precision.round(RANDOM.nextDouble(), 2);
    }

    public static <T> T randomElement(List<T> list) {
        return list.get(RANDOM.nextInt(list.size()));
    }
}
