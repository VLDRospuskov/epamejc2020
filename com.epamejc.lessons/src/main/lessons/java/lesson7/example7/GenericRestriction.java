package lessons.java.lesson7.example7;

public class GenericRestriction<T> {

    private T x; // error
    private T y;

    public GenericRestriction(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public static <Type> void method(Type obj) {
//        T var; // error
        Type typeVar;
    }

}
