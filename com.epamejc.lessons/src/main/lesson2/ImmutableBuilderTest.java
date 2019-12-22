package main.lesson2;

public class ImmutableBuilderTest {
    public static void main(String[] args) {
        ImmutableClass immutableClass = new ImmutableClass.ImmutableClassBuilder(1, "Name").build();

        System.out.println(immutableClass.getId());
        System.out.println(immutableClass.getName());
    }
}
