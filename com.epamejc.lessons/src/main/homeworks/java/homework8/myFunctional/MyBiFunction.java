package main.homeworks.java.homework8.myFunctional;

@FunctionalInterface
public interface MyBiFunction<T, U, R> {
    R apply(T t, U u);
}
