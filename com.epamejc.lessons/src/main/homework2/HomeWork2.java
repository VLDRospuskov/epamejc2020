package main.homework2;

/* Creating an immutable class */

public class HomeWork2 {

    public static void main(String[] args) {
        ImmutableClass immutableClass = ImmutableClass.createInstance("one", 1);
        System.out.println(immutableClass.strField);
        System.out.println(immutableClass.intField);
    }


    public static final class ImmutableClass {
        final private String strField;
        final private int intField;

        public ImmutableClass(String strField, int intField) {
            this.strField = strField;
            this.intField = intField;
        }

        public static ImmutableClass createInstance(String strField, int intField) {
            return new ImmutableClass(strField, intField);
        }

        public String getStrField() {
            return strField;
        }

        public int getIntField() {
            return intField;
        }
    }
}
