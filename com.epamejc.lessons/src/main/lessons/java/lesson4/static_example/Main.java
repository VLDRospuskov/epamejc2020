package lessons.java.lesson4.static_example;

import lessons.java.lesson4.static_example.utils.StringUtils;
import static lessons.java.lesson4.static_example.utils.StringUtils.printMsg;

public class Main {

    public static void main(String[] args) {
        Cat cat1 = new Cat(1, "Barsik");
        Cat cat2 = new Cat(2, "Murzik");

        System.out.println(Cat.getCount());

        double sqrt = Math.sqrt(16);
        printMsg(String.valueOf(sqrt));
        printMsg(StringUtils.reverse("Hello"));
    }

}
