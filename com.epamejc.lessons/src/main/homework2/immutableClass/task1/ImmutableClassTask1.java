package main.homework2.immutableClass.task1;

/* Creating an immutable class */

public class ImmutableClassTask1 {

    public static void main(String[] args) {
        ImmutableClass immutableClassInstance1 = new ImmutableClass("one", 1);
        ImmutableClass immutableClassInstance2 = new ImmutableClass("two", 2);

        System.out.println(immutableClassInstance1.intField);
        System.out.println(immutableClassInstance2.strField);

//        immutableClassInstance1.intField = 11;
//        immutableClassInstance2.strField = "twotwo";
    }


    public static final class ImmutableClass {
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
}
