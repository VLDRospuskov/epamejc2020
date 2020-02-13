package homeworks.java.immutableClass;

/**
 * The goal is to create an immutable class, make some objects, look how it works.
 * <p>
 * {@code double piValue = pi.constant;} is illegal action, at the first place because pi fields are private,
 * but they are final as well, so the following is also illegal: {@code pi.constant = 3.15;}.
 * <p>
 * We can only create a new object, using all args constructor, and get the values of its fields using
 * getters.
 * <p>
 * Immutable class can't be extended because of final modifier. But if we brake a bit the rules of immutable class
 * construction as represented in NotImmutable class, we can extend it and add setter methods, or another logic.
 *
 * @author Vladimir Ivanov
 */
public class Main {


    public static void main(String[] args) throws IllegalArgumentException {
        Immutable pi = new Immutable(3.14, "pi");

        System.out.println(pi);
        System.out.println(pi.getConstant());
        System.out.println(pi.getConstantName());

        class NotImmutable1 extends NotImmutable {

            private NotImmutable1(double constant, String constantName) {

                super(constant, constantName);

            }

            private void setConstant(double constant) {

                this.constant = constant;

            }

            private void setConstantName(String constantName) {

                this.constantName = constantName;

            }

        }

        NotImmutable1 pi2 = new NotImmutable1(3.14, "pi");
        System.out.println(pi2);

        pi2.setConstant(5);
        pi2.setConstantName("beliberda");

        System.out.println(pi2);

    }

}
