package homeworks.java.immutableClass;

import lombok.*;

@EqualsAndHashCode
@ToString
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

}
