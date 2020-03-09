package homeworks.java.java8.part1;

@FunctionalInterface
public interface MyBiFunction<T, U, V> {

    V apply(T t, U u);

}
