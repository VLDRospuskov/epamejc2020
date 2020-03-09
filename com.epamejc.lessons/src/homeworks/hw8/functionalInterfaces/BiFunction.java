package homeworks.hw8.functionalInterfaces;

@java.lang.FunctionalInterface
public interface BiFunction<T, U, R> {

    R apply(T t, U u);
}
