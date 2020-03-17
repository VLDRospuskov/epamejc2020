package homeworks.homework08.part1;

@FunctionalInterface
public interface MyBiFunction<T, U, R> {
    R apply(T t, U u);
}
