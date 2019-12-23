package main.homework2;

/* Creating an immutable class */

public class HomeWork2 {

    public static void main(String[] args) {
        ImmutableClass immutableClass = new ImmutableClass("one", 1);
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

        public String getStrField() {
//            ImmutableClass immutableClass = new ImmutableClass(strField, this.intField);
            return strField;
        }

        public int getIntField() {
//            ImmutableClass immutableClass = new ImmutableClass(this.strField, intField);
            return intField;
        }
    }
}
