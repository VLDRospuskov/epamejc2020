package main.lesson2;

final public class ImmutableClass {
    final private int[] ar;
    final private String name;
    final private double aDouble;

    public ImmutableClass(int[] ar, String name, double aDouble){
        this.ar = ar;
        this.name = name;
        this.aDouble = aDouble;
    }

    public int[] getAr(){
       return ar;
    }


    public String getName(){
        return name;
    }

    public double getaDouble(){
        return aDouble;
    }

}
