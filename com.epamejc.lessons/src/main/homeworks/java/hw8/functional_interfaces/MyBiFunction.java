package homeworks.java.hw8.functional_interfaces;

@FunctionalInterface
public interface MyBiFunction<T, U, R> {

    R apply(T t, U u);

}
