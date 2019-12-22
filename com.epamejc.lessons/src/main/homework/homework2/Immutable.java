package main.homework.homework2;

public final class Immutable {

    final private Integer immutableField;

    public Immutable(Integer value) {
        immutableField = value;
    }

    public Integer getField() {
        return immutableField;
    }

    public static void main(String[] args) {
        Immutable object = new Immutable(0);

        System.out.println("Immutable object was created");
    }
}
