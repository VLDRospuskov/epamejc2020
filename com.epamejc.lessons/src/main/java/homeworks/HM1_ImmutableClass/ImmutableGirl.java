package homeworks.HM1_ImmutableClass;

import java.util.Stack;

public final class ImmutableGirl {

    private int age;
    private String name;
    private Stack<String> clothes;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Stack<String> getClothes() {
        return (Stack<String>) clothes.clone();
    }

    public ImmutableGirl(int id, String name) {
        this.age = id;
        this.name = name;
        this.clothes = new Stack<>();
        this.clothes.push("underwear");
        this.clothes.push("outerwear");
    }

    @Override
    public String toString() {
        return "ImmutableGirl{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", clothes=" + clothes.peek() +
                '}';
    }

}