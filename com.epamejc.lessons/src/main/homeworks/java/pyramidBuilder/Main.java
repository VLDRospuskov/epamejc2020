package homeworks.java.pyramidBuilder;

/**
 * Program builds and prints a pyramid in the console.
 *
 * @author Vladimir Ivanov
 */
public class Main {

    public static void main(String[] args) {

        Pyramid pyramid = new Pyramid();
        pyramid.buildPyramid(15);
        System.out.println(pyramid);

    }

}
