package lessons.lesson1.primitives;

public class Main {

    public static void main(String[] args) {
        int i = 2147483647;
        System.out.println(i + 2);

        float d = 0 * 0.15f;
        long g = 2147483647;

        System.out.println(d);
        System.out.println(g);
        int maxValue = Integer.MAX_VALUE;
        System.out.println(maxValue);

        float negativeInfinity = Float.NEGATIVE_INFINITY;
        System.out.println(negativeInfinity);
        float positiveInfinity = Float.POSITIVE_INFINITY;
        System.out.println(positiveInfinity);

        char ch = '$';
        boolean javaIdentifierStart = Character.isJavaIdentifierStart(ch);
        System.out.println(javaIdentifierStart);
    }

}
