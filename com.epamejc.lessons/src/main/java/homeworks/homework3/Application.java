package homeworks.homework3;

public class Application {
    public static void main(String[] args) {

        MultipleArrayBuilder builder = new MultipleArrayBuilder();
        char[][] arr = builder.createArray(4, 4);

        builder.printArray(arr);
        builder.printEven(arr);
        builder.printOdd(arr);
        builder.pyramid(10);
    }

}
