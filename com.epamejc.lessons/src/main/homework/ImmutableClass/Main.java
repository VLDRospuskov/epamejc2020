package homework.ImmutableClass;

public class Main  {
    public static void main(String[] args) {

        ImmutableClass immutableObject = new ImmutableClass(5);
        ImmutableClass b = immutableObject.toPlusOne();
        System.out.println(immutableObject);
        System.out.println(b);

        ImmutableClass c = immutableObject.plus(b);
        System.out.println(c);

        int a = b.getValue();
        System.out.println(a^2);
        System.out.println(b.XOR(new ImmutableClass(2)));

        try {
            System.out.println(b.clone().equals(b.copy()));
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

    }
}
