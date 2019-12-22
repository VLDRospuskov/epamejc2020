package main.lesson2;
/*
Don't provide "setter" methods
Make all fields final and private.
Don't allow subclasses to override methods.
If the instance fields include references to mutable objects, don't allow those objects to be changed
*/


public final class ImmutableClass {


    public ImmutableClass(int a) {
        this.a = a;
    }

    private final int a;

    public int getA() {
        return a;
    }
    
}
