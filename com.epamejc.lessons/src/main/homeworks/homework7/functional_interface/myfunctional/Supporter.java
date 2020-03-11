package homeworks.homework7.functional_interface.myfunctional;

@FunctionalInterface
public interface Supporter<T extends RuntimeException> {

    T notifi();
}
