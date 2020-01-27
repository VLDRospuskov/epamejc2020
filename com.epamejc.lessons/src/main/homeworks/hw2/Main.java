package main.homeworks.hw2;

public class Main {
    public static void main(String[] args) {
        ImmutableInt ii = new ImmutableInt(17);
        ImmutableInt i2 = new ImmutableInt(256);

        System.out.println("System.out.println(ii): " + ii); // link to ii instance
        // System.out.println(ii.value); // wrong
        System.out.println("System.out.println(ii.getValue()): " + ii.getValue());
        // int i = ii.value; // wrong
        int i = i2.getValue();
        System.out.println("int i = ii.getValue()\nSystem.out.println(i): " + i);
    }
}
