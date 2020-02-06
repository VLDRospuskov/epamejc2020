package homeworks.homework2.immutable;

public final class User {
    private final String name;
    private final int age;


    public User(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }


}
