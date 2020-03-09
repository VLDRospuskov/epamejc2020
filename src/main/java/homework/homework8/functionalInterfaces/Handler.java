package homework.homework8.functionalInterfaces;

public interface Handler<T, U, R> {
    R handle(T t, U u);
}