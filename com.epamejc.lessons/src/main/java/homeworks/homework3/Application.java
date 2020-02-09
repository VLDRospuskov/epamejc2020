package homeworks.homework3;

public class Application {
    public static void main(String[] args) {

        MultipleArrayBuilder builder = new MultipleArrayBuilder();
        char[][] arr = builder.createArray(4, 4);

        System.out.println(builder.printArray(arr));
        System.out.print("even chars: " + builder.printEven(arr));
        System.out.print("odd chars: " + builder.printOdd(arr));
        System.out.println("Behold a pyramid!");
        System.out.println(builder.pyramid(10));
    }

}
