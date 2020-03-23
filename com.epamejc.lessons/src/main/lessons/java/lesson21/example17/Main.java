package lessons.java.lesson21.example17;

import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        final Predicate<String> predicate1 = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return false;
            }
        };
        final Predicate<String> predicate = (String s) -> false;
    }
}
