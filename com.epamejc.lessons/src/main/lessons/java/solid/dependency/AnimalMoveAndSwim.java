package lessons.java.solid.dependency;

public interface AnimalMoveAndSwim {

    void swim();

    default void walk() {
        System.out.println("Cant walk");
    }

}
