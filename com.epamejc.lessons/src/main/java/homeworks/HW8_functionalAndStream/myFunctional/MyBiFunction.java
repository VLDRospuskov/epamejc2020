package homeworks.HW8_functionalAndStream.myFunctional;

@FunctionalInterface
public interface MyBiFunction<T, U, R> {

    R apply(T t, U u);

}
