package main.HW2.Number1;

public final class ImmutableClass {

    private final int id;
    private final String name;
    private final Age age;


    public ImmutableClass(int id, String name, Age age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Age getAge() {
        return age;

    }
}
