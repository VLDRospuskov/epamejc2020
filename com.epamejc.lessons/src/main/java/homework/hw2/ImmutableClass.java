package homework.hw2;

public final class ImmutableClass implements Cloneable {

    @Override
    public ImmutableClass clone () throws CloneNotSupportedException {
        return (ImmutableClass)super.clone();
    }

    ImmutableClass(ImmutableClass other) {
        value = other.value;
    }

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

    ImmutableClass XOR(ImmutableClass a) {
        return new ImmutableClass(this.value ^ a.getValue());
    }

    @Override
    public boolean equals(Object a) {
        return a instanceof ImmutableClass && ((ImmutableClass) a).value == this.value;
    }


}

