package homework.homework5;

public interface Handler<T, U, R> {
    R handle(T t, U u);
}