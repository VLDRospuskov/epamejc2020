package lessons.java.lesson14.example15;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<DAYS> days = Collections.synchronizedSet(EnumSet.allOf(DAYS.class));

        System.out.println(days);

    }
}
