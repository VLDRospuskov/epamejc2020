package homeworks.java.immutableClass;

import java.util.Objects;

public final class Immutable {

    private final double constant;
    private final String constantName;

    public Immutable(double constant, String constantName) {
        this.constant = constant;
        this.constantName = constantName;
    }

    public double getConstant() {
        return constant;
    }

    public String getConstantName() {
        return constantName;
    }

    //public double setConstant(double constant) {
    //    this.constant = constant;
    //}
    //cannot assign a value to a final field constant1

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Immutable immutable = (Immutable) o;
        return Double.compare(immutable.constant, constant) == 0 &&
                immutable.constantName.equals(constantName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(constant, constantName);
    }

    @Override
    public String toString() {
        return constantName + " = " + constant + "\n";
    }
}
