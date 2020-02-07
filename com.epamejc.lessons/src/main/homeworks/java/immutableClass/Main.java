package homeworks.java.immutableClass;

public class Main {
    public static void main(String[] args) {
        Immutable ex1 = new Immutable(3.14, "Pi");
        Immutable ex2 = new Immutable(7.87, "SomeConst");
        Immutable ex3 = new Immutable(0.33, "AnotherOne");
        Immutable ex4 = new Immutable(3.14, "Pi");


        System.out.println(ex1 == ex2);
        System.out.println(ex1.equals(ex2));
        System.out.println(ex1 == ex3);
        System.out.println(ex1.equals(ex3));
        ex3 = ex1;
        System.out.println(ex1 == ex3);
        System.out.println(ex1.equals(ex3));
        System.out.println(ex1 == ex4);
        System.out.println(ex1.equals(ex4));

        double x = ex1.getConstant();
        System.out.println(x + " " + ex1.getConstant());
        x = 0;
        //ex1.constant1 = 0; field constant1 has a private access.
        System.out.println("" + ex1 + ex2 + ex3);


    }
}
