package lessons.lesson17.example4;

@FunctionalInterface
public interface MyFunction<T, R> {

    R applyFunc(T t);

}
