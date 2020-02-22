package homeworks.java.HM1_ImmutableClass;

import java.util.Stack;

public final class ImmutableGirl {
    public static void main(String[] args) {
        ImmutableGirl someGirl = new ImmutableGirl(18, "Sasha");

        System.out.println(someGirl.toString());

        int newage = someGirl.getAge();
        String newname = someGirl.getName();
        Stack<String> undressTry = someGirl.getClothes();
        newage = 16;
        newname = "Anatoliy";
        undressTry.pop();

        System.out.println(someGirl.toString());
    }

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