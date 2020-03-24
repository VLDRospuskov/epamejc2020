package homework.hw9;

@FunctionalInterface
public interface CustomBiFunction <C, A, B> {
    C apply (A a, B b);
}
