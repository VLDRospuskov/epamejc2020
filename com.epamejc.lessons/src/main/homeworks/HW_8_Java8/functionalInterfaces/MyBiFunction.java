package homeworks.HW_8_Java8.functionalInterfaces;

@FunctionalInterface
public interface MyBiFunction<T, U, R> {
    R apply(T t, U u);
}
