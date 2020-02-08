package main.java.homework2.task1;



public class ImmutableClass {

    final private String strField;
    final private int intField;

    ImmutableClass(String strField, int intField) {
        this.strField = strField;
        this.intField = intField;
    }

    public String getStrField() {
        return strField;
    }

    public int getIntField() {
        return intField;
    }

}
