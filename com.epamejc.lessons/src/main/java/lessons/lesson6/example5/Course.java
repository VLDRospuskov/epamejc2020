package lessons.lesson6.example5;

public interface Course {

    int x = 15;

    default void print() {
        System.out.println("Course");
    }
}
