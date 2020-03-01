package homework.CustomFunctionalInterfaces;

@FunctionalInterface
public interface CustomBiFunction <C, A, B> {
    C apply (A a, B b);
}
