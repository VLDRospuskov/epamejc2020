package homework.homework2;

public class Main {
    public static void main(String[] args) {
        Immutable immutable = new Immutable(22);
        System.out.println("Immutable object was created");
        System.out.println("value = " + immutable.getValue());
        immutable = new Immutable(66);
        System.out.println("value = " + immutable.getValue());
    }
}
