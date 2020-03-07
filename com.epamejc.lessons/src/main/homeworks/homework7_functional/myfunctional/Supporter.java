package homeworks.homework7_functional.myfunctional;

@FunctionalInterface
public interface Supporter<T extends RuntimeException> {
     T notifi();
}
