package main.homeworks.immutableClass;

public class Homework2 {

    public static void main(String[] args) {
        int[] ints = {1,2,3,4,5,6};
        String string = "Igor";
        double aDouble = 3.14;

        ImmutableClass immutableClass = new ImmutableClass(ints,string,aDouble);

        int[] newInts = immutableClass.getAr();
        String newString = immutableClass.getName();
        double newDouble = immutableClass.getaDouble();

        for (int i=0;i<newInts.length-1;i++){
            System.out.println(newInts[i]);
        }

        System.out.println("String= " + newString);
        System.out.println("Double= " + newDouble);
    }


}
