package homeworks.homework8.functional_interfaces.interfaces;

@FunctionalInterface
public interface MyBiFunction<T, U, R> {

    R apply(T t, U u);
}
