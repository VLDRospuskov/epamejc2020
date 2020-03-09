package homeworks.java.java8.part1;

@FunctionalInterface
public interface MyFunction<T, V> {

    V apply(T t);

}
