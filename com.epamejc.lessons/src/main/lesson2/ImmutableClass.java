package main.lesson2;
public final class ImmutableClass implements Cloneable {


    ImmutableClass(int a) {
        this.value = a;
    }

    private final int value;

    @Override
    public String toString() {
        return Integer.toString(this.value);
    }

    int getValue() {
        return this.value;
    }

    ImmutableClass copy() {
        return new ImmutableClass(this.value);
    }

    ImmutableClass toPlusOne() {
        return new ImmutableClass(this.value + 1);
    }

    ImmutableClass plus(ImmutableClass other) {
        return new ImmutableClass(this.value + other.value);
    }

    ImmutableClass XOR (ImmutableClass a){
        return new ImmutableClass(this.value ^ a.getValue());
    }
    @Override
    public boolean equals(Object a){
        return a instanceof ImmutableClass && ((ImmutableClass) a).value == this.value;
    }

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

