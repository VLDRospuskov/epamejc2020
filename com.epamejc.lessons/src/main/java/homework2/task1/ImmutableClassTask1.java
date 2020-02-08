package main.java.homework2.task1;

public class ImmutableClassTask1 {

    public static void main(String[] args) {
        ImmutableClass immutableClassInstance1 = new ImmutableClass("one", 1);
        ImmutableClass immutableClassInstance2 = new ImmutableClass("two", 2);

        System.out.println(immutableClassInstance1.getIntField());
        System.out.println(immutableClassInstance2.getStrField());
    }
}
