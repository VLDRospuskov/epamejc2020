package main.lessons.lesson9.solid.interface_seg;

public interface AnimalMoveAndSwim {

    void swim();

    default  void walk() {
        System.out.println("Cant walk");
    }

}
