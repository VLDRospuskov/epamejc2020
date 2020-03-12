package lessons.lesson4.static_example;

import lessons.lesson4.static_example.utils.StringUtils;

public class Main {
    
    public static void main(String[] args) {
        Cat cat1 = new Cat(1, "Barsik");
        Cat cat2 = new Cat(2, "Murzik");
        
        System.out.println(Cat.getCount());
        
        double sqrt = Math.sqrt(16);
        StringUtils.printMsg(String.valueOf(sqrt));
        StringUtils.printMsg(StringUtils.reverse("Hello"));
    }
    
}
