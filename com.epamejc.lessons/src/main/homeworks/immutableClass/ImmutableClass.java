package main.homeworks.immutableClass;

final class ImmutableClass {
    final private int[] ar;
    final private String name;
    final private double aDouble;

    ImmutableClass(int[] ar, String name, double aDouble) {
        this.ar = ar;
        this.name = name;
        this.aDouble = aDouble;
    }

    int[] getAr() {
        return ar;
    }


    String getName() {
        return name;
    }

    double getaDouble() {
        return aDouble;
    }

}
