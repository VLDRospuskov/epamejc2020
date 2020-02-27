package homeworks.java.hw8.myFunctional;

@FunctionalInterface
public interface MyFunction<T, U, R> {

    R apply(T t, U u);

}
