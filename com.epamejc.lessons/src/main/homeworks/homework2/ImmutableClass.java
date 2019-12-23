package main.homeworks.homework2;

/*
Class ImmutableClass storing some constant double value in field constValue.
This class has modifier final to prevent overriding in child classes.
Field constValue is final to prevent any possibility to change its value even by mistake.
Initialisation of the final field constValue occurs in class constructor.
Class field access provided by method getConstValue.
 */
public final class ImmutableClass {

    private final double constValue;

    public ImmutableClass (double constValue) {
        this.constValue = constValue;
    }

    public double getConstValue(){
        return constValue;
    }

}
