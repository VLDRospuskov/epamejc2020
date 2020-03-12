package homework.homework9.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class IdGenerator {

    private static final Random RANDOM = new Random();

    public static Set<Integer> generateIds(int count) {
        Set<Integer> ids = new HashSet<>();

        while (ids.size() < count) {
            ids.add(RANDOM.nextInt(30));
        }

        return ids;
    }
}
