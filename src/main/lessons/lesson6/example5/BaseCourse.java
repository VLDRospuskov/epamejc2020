package main.lessons.lesson6.example5;

public interface BaseCourse {

    int x = 10;

    default void print() {
        System.out.println("BaseCourse");
    }
}
