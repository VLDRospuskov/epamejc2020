package homework8.task1;


@FunctionalInterface
public interface MyBiFunction<T, U, R> {
    R apply(T t, U u) ;
}
