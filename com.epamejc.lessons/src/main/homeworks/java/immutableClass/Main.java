package homeworks.java.immutableClass;

public class Main {


    public static void main(String[] args) throws IllegalArgumentException {
        Immutable pi = new Immutable(3.14, "pi");

        double piValue = pi.getConstant();
        //piValue = pi.constant; illegal action

        //pi.constant = 3.66; also illegal
        System.out.println(pi);

        class NotImmutable1 extends NotImmutable {
            NotImmutable1(double constant, String constantName) {
                super(constant, constantName);
            }

            public void setConstant(double constant) {
                this.constant = constant;
            }

            public void setConstantName(String constantName) {
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
