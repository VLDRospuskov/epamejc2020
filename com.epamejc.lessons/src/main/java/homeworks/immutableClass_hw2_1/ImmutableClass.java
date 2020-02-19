package homeworks.immutableClass_hw2_1;

public final class ImmutableClass {
    final private int[] ar;
    final private String name;
    final private double doubleValue;

    public ImmutableClass(int[] ar, String name, double aDouble) {
        this.ar = ar;
        this.name = name;
        this.doubleValue = aDouble;
    }

    public int[] getAr() {
        return ar;
    }


    public String getName() {
        return name;
    }

    public double getDoubleValue() {
        return doubleValue;
    }

}
